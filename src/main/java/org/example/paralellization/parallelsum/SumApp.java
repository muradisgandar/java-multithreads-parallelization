package org.example.paralellization.parallelsum;

import java.util.Random;

public class SumApp {

    public static void main(String[] args) {

        Random rand = new Random();
        int[] nums = new int[10000000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(100);
        }

        int n = Runtime.getRuntime().availableProcessors();

        // sequential algorithm
        SequentialSum sequentialSum = new SequentialSum();
        long start = System.currentTimeMillis();

        System.out.println("Sum: " + sequentialSum.sum(nums));
        System.out.println("Time: " + (System.currentTimeMillis() - start));

        // parallel algorithm
        ParallelSum parallelSum = new ParallelSum(n);
        start = System.currentTimeMillis();

        System.out.println("Sum: " + sequentialSum.sum(nums));
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }
}
