package org.example.concurrentcolections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class PriorityBlockingWorker1 implements Runnable {

    private BlockingQueue<Person> queue;

    public PriorityBlockingWorker1(BlockingQueue<Person> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put(new Person(12, "Adam"));
            queue.put(new Person(55, "Kevin"));
            queue.put(new Person(27, "Ana"));
            Thread.sleep(2000);
            queue.put(new Person(31, "Daniel"));
            Thread.sleep(1000);
            queue.put(new Person(15, "Joe"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class PriorityBlockingWorker2 implements Runnable {

    private BlockingQueue<Person> queue;

    public PriorityBlockingWorker2(BlockingQueue<Person> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println(queue.take());
            Thread.sleep(1000);
            System.out.println(queue.take());
            Thread.sleep(2000);
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Person implements Comparable {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Object person) {
        return name.compareTo(((Person) person).getName());
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class PriorityBlockingQueueExample {

    public static void main(String[] args) {

        BlockingQueue<Person> queue = new PriorityBlockingQueue<>();

        PriorityBlockingWorker1 first = new PriorityBlockingWorker1(queue);
        PriorityBlockingWorker2 second = new PriorityBlockingWorker2(queue);

        new Thread(first).start();
        new Thread(second).start();



    }
}
