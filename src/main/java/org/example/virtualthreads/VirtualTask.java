package org.example.virtualthreads;

public class VirtualTask {

    public static void run() {
        System.out.println("Started... " + Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Finish... " + Thread.currentThread().getName());
    }
}
