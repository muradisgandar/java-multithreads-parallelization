package org.example.structuredunstructuredconcurrency;

import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrencyApp1 {

    public static void main(String[] args) {

        // we dont pool virtual threads: we create new ones for every task
        // and we dispose them after they finished
        try(var scope = new StructuredTaskScope<String>()) {

            var process1 = new LongProcessFail(3, "result 1", true);
            var process2 = new LongProcessFail(2, "result 2", false);

            // we submit tasks in parallel
            StructuredTaskScope.Subtask<String> res1 = scope.fork(process1);
            StructuredTaskScope.Subtask<String> res2 = scope.fork(process2);

            // Because virtual threads
            scope.join();

            // we can combine results
            // get() will not block because join() waits for the thread to finish
            if (res1.state() == StructuredTaskScope.Subtask.State.SUCCESS) {
                System.out.println(res1.get());
            }
            if (res2.state() == StructuredTaskScope.Subtask.State.SUCCESS) {
                System.out.println(res2.get());
            }

        }

    }
}
