package org.example.creatingthreadswithexecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task2 implements Runnable {

    private int id;

    public Task2(int id) {
        this.id = id;
    }

    @Override
    public void run() {

        System.out.println("Task with id: " + id + " is in work - thread id: " + Thread.currentThread().getId());
        long duration = (long) (Math.random() * 5);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class FixedThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executor.execute(new Task2(i +1));
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(10000, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            };
        } catch (InterruptedException ex) {
            executor.shutdownNow();
        }
    }
}
