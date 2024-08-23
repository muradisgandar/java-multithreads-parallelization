package org.example.forkjoinframework;

import java.util.concurrent.ForkJoinPool;

public class ForkApp {

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool(); // bu default it uses default cpu size (Runtime.getRuntime().availableProcessors());
//        SimpleRecursiveAction action = new SimpleRecursiveAction(800);
//        action.invoke();

        SimpleRecursiveTask task = new SimpleRecursiveTask(300);
        System.out.println(pool.invoke(task));
        System.out.println(task.invoke());
    }
}
