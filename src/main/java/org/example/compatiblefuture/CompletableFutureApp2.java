package org.example.compatiblefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureApp2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        try(var service = Executors.newVirtualThreadPerTaskExecutor()) {
            String res = CompletableFuture
                    .supplyAsync(DbQuery::run, service)
                    .thenCombine(CompletableFuture.supplyAsync(RestQuery::run, service),
                            (res1, res2) -> res1 + res2)
                    .join();

            System.out.println(res);
        }

        CompletableFuture.supplyAsync(() -> "Hello")
                .thenCombine(CompletableFuture.supplyAsync(() -> "World"), (s1, s2) -> s1 + " - " + s2)
                .thenApply(s-> s.toUpperCase())
                .thenAccept(System.out::println);


    }
}
