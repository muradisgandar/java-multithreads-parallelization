package org.example.concurrentcolections;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BarrierWorker implements Runnable {

    private int id;
    private Random random;
    private CyclicBarrier barrier;

    public BarrierWorker(int id, CyclicBarrier barrier) {
        this.id = id;
        this.random = new Random();
        this.barrier = barrier;
    }

    @Override
    public void run() {
        doWork();
    }

    private void doWork() {
        System.out.println("Thread with id " + this.id + " starts the work...");
        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            //when all the threads call await(),
            // logic that defined in CyclicBarrier runnable will start to execute
            // after this execution code lines that defined in doWork() method (after await()) will be executed
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

}

public class CyclicBarrierExample {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(5);
        // 5 number of parties or number of threads
        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("All tasks have been finished");
            }
        });

        for (int i = 0; i < 5; ++i) {
            service.execute(new BarrierWorker(i+1, barrier));
        }

        service.shutdown();

    }


}
