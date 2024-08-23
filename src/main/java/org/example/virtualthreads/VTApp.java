package org.example.virtualthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VTApp {

    public static void main(String[] args) throws InterruptedException {
        // approach #3 try with resources
        try(var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(VirtualTask::run);
            executor.submit(VirtualTask::run);
            executor.submit(VirtualTask::run);
        }


        // approach #2
        /*var factory = Thread.ofVirtual().name("virtual-", 0).factory();

        var t1 = factory.newThread(VirtualTask::run);
        var t2 = factory.newThread(VirtualTask::run);

        t1.start();
        t2.start();

        t1.join();
        t2.join();*/

        // approach #1
        /*var builder = Thread.ofVirtual().name("virtual-", 0);

        var t1 = builder.start(new VirtualTask());
        var t2 = builder.start(new VirtualTask());

        t1.join();
        t2.join();*/

    }
}
