package org.example.forkjoinframework.printintegers;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class PrintApp {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        PrintTask printTask = new PrintTask(Arrays.asList(1,2,3,4,5,6,7,8,9,0));

        printTask.invoke();
    }

}
