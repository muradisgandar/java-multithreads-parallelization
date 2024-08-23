package org.example.streams.parallelstreams;

import java.util.stream.LongStream;

public class Example1 {

    public static void main(String[] args) {
        // parallel() - because we have to make sure that he given
        // stream can be parallelized
        // under the hood the fork-join framework is used

        long now = System.currentTimeMillis();
        System.out.println(sum(1000000000));
        System.out.println("Time taken: " + (System.currentTimeMillis() - now));
        now = System.currentTimeMillis();
        System.out.println(parallelSum(1000000000));
        System.out.println("Time taken: " + (System.currentTimeMillis() - now));

    }

    private static long sum(long n) {
        return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
    }

    private static long parallelSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
    }

}
