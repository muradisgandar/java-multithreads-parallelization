package org.example.concurrentcolections.copyonwriteexample;

public class CopyOnWriteArrayExample {

    public static void main(String[] args) {
        ConcurrentArray concurrentArray = new ConcurrentArray();
        concurrentArray.simulate();
    }
}
