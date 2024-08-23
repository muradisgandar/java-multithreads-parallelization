package org.example.concurrentcolections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class DelayedWorker implements Delayed {

    private long duration;
    private String message;

    public DelayedWorker(long duration, String message) {
        this.duration = System.currentTimeMillis() + duration;
        this.message = message;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(duration - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        if (duration < ((DelayedWorker) other).getDelay(TimeUnit.MILLISECONDS) ) {
            return -1;
        }
        if (duration > ((DelayedWorker) other).getDelay(TimeUnit.MILLISECONDS) ) {
            return 1;
        }

        return 0;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DelayWorker{" +
                "message='" + message + '\'' +
                '}';
    }
}

public class DelayQueueExample {

    public static void main(String[] args) {
        BlockingQueue<DelayedWorker> queue = new DelayQueue<>();
        try {
            //these can be inserted by different threads
            queue.put(new DelayedWorker(2000, "This is the first message..."));
            queue.put(new DelayedWorker(10000, "This is the second message..."));
            queue.put(new DelayedWorker(4500, "This is the third message..."));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //we can get the messages
        while (!queue.isEmpty()) {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

