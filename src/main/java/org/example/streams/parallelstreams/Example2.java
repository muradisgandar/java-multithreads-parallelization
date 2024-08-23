package org.example.streams.parallelstreams;

import java.util.stream.IntStream;

public class Example2 {

    public static void main(String[] args) {
        // sequential stream
        long currentTime = System.currentTimeMillis();
        long numOfPrimes = IntStream.range(2, Integer.MAX_VALUE/2).filter(Example2::isPrime).count();
        System.out.println("Num of primes (sequential): " + numOfPrimes);
        System.out.println("Time take: " + (System.currentTimeMillis() - currentTime));

        // parallel stream
        currentTime = System.currentTimeMillis();
        long numOfPrimes2 = IntStream.range(2, Integer.MAX_VALUE/2).filter(Example2::isPrime).parallel().count();
        System.out.println("Num of primes (parallel): " + numOfPrimes2);
        System.out.println("Time take: " + (System.currentTimeMillis() - currentTime));
    }

    public static boolean isPrime(long num) {

        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        // we can check the numbers in the range [0, sqrt(N)]
        long maxDivisor = (long) Math.sqrt(num);
        for (int i = 3; i < maxDivisor; i+=2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

}
