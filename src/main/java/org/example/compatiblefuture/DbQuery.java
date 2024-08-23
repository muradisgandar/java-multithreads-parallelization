package org.example.compatiblefuture;

public class DbQuery {

    public static String run() {
        System.out.println("DB operation started...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Running query...");
        return "DB query result";
    }

}
