package org.example.streams.parallelstreams;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class ParallelSaveOperation {

    public static final String DIRECTORY = System.getProperty("user.dir") + "/test/";

    public static void main(String[] args) throws IOException {
        // create the directory
        Files.createDirectories(Paths.get(DIRECTORY));

        ParallelSaveOperation app = new ParallelSaveOperation();

        // generate large number of Person objects
        List<Person> people = app.generatePeople(10000);

        // sequential algorithm
        long start = System.currentTimeMillis();
        people.forEach(ParallelSaveOperation::save);
        System.out.println("Time taken: " + (System.currentTimeMillis() - start));

        // parallel algorithm
        start = System.currentTimeMillis();
        people.stream().parallel().forEach(ParallelSaveOperation::save);
        System.out.println("Time taken: " + (System.currentTimeMillis() - start));

    }

    private static void save(Person person) {
        try(FileOutputStream fos = new FileOutputStream(DIRECTORY + person.getPersonId() + ".txt")) {

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private List<Person> generatePeople(int num) {
        return Stream.iterate(0, n -> n+1).limit(num).map(Person::new).toList();
    }

}
