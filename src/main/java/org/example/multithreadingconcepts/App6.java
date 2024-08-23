package org.example.multithreadingconcepts;

class Worker implements Runnable {

    private volatile boolean terminated;

    @Override
    public void run() {
        while (!terminated) {
            System.out.println("Working class in running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }
}

public class App6 {
    public static void main(String[] args) {

        Worker worker = new Worker();

        Thread t1 = new Thread(worker);

        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        worker.setTerminated(true);
        System.out.println("Algorithm is terminated...");

    }
}
