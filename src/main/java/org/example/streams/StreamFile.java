package org.example.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFile {

    public static void main(String[] args) throws IOException {
        String path = "/Users/muradisgandarli/Documents/Udemy/Repos/threads-udemy-lesson/src/main/java/org/example/streams/names";

        Stream<String> namesStream = Files.lines(Paths.get(path));

        List<String> names = namesStream.toList();

        names.forEach(System.out::println);

    }


}
