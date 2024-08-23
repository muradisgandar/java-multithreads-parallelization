package org.example.virtualthreads;

import java.time.Duration;
import java.util.concurrent.Executors;

public class ComparisonPlatformVirtual {

    public static void main(String[] args) {

        var service = Executors.newVirtualThreadPerTaskExecutor();

        for (int i = 0; i < 1000000; i++) {
//            Thread.ofPlatform().start(() -> {
//                try {
//                    System.out.println("Started: " + Thread.currentThread());
//                    Thread.sleep(Duration.ofSeconds(5));
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            });
            service.submit(() -> {
                try {
                    System.out.println("Thread: " + Thread.currentThread());
                    Thread.sleep(Duration.ofSeconds(1));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }


    }
}
