package org.example.compatiblefuture;

public class RestQuery {

    public static String run() {
        System.out.println("RestQuery operation started...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Running RestQuery...");
        return "RestQuery result";
    }
}
