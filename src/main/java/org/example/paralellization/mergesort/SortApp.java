package org.example.paralellization.mergesort;

import java.util.Random;

public class SortApp {

    public static void main(String[] args) {
        int numOfThreads = Runtime.getRuntime().availableProcessors();

        int[] numbers1 = createArray(10);
        int[] numbers2 = new int[numbers1.length];

        for (int i = 0; i < numbers1.length; i++) {
            numbers2[i] = numbers1[i];
        }

        // PARALLEL MERGE SORT
        ParallelMergeSort parallelSorter = new ParallelMergeSort(numbers1);

        long startTime = System.currentTimeMillis();
        parallelSorter.parallelMergeSort(0, numbers1.length - 1, numOfThreads);
        long endTime = System.currentTimeMillis();
        System.out.printf("Time taken with parallel: %6d ms\n", endTime - startTime);

        // SEQUENTIAL MERGE SORT
        startTime = System.currentTimeMillis();
        SequentialMergeSort sequentialSorter = new SequentialMergeSort(numbers2);
        sequentialSorter.sort();
        endTime = System.currentTimeMillis();
        System.out.printf("Time taken with sequential: %6d ms\n", endTime - startTime);



    }

    private static int[] createArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }

        return array;
    }

}
