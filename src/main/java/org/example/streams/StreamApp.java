package org.example.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApp {

    public static void main(String[] args) {

//        IntStream.range(0, 10).filter(x -> x > 4).forEach(System.out::println);

//        String names[] = {"Adam", "Daniel", "Martha", "Kevin", "Ben", "Joe", "Brad", "Susan"};

//        Stream.of(names).sorted(Comparator.reverseOrder()).forEach(System.out::println);

        List<Book> books = new ArrayList<>();
        books.add(new Book("Being and Time", "Heidegger", 560, Type.PHILOSOPHY));
        books.add(new Book("The Trial", "Franz Kafka", 240, Type.NOVEL));
        books.add(new Book("Death on The Nile", "Agatha Christie", 370, Type.THRILLER));
        books.add(new Book("Ancient Greece", "Robert F.", 435, Type.HISTORY));
        books.add(new Book("Ancient Rome", "Robert F.", 869, Type.HISTORY));
        books.add(new Book("Death of Virgil", "Hermann Broch", 590, Type.NOVEL));
        books.add(new Book("The Stranger", "Albert Camus", 560, Type.NOVEL));

        // map
        List<String> words = Arrays.asList("Adam", "Ana", "Daniel");

        List<Integer> lengths = words.stream().map(String::length).toList();
//        lengths.forEach(System.out::println);

        // create a list containing the squared values
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);

//        nums.stream().map(x-> x * x).toList().forEach(System.out::println);

        // flatMap
        String[] array = {"hello", "shell"};
        List<String> unique = Arrays.stream(array).map(w -> w.split(""))
                .flatMap(Arrays::stream).distinct().toList();
        unique.forEach(System.out::println);


        // grouping by type
//        Map<Type, List<Book>> booksByType = books.stream().collect(Collectors.groupingBy(Book::getType));

        // finding 2 longest books by page
        // short-circuiting and loop fusion
//        List<String> longestBooks = books.stream()
//                .filter(p -> {
//                    System.out.println("Filtering " + p.getTitle());
//                    return p.getPages() > 500;
//                })
//                .map(b -> {
//                    System.out.println("Mapping " + b.getTitle());
//                    return b.getTitle();
//                })
//                .limit(2).toList();

//        booksByType.entrySet().forEach(System.out::println);
//        longestBooks.forEach(System.out::println);

        // external iteration (collections)
//        List<String> titles = new ArrayList<>();
//
//        Iterator<Book> iterator = books.iterator();
//
//        // inherently sequential approach
//        // no parallelization
//        while (iterator.hasNext()) {
//            Book book = iterator.next();
//            titles.add(book.getTitle());
//        }
//
//        // stream API - internal iteration
//        List<String> titles2 = books.stream().map(Book::getTitle).toList();
//        titles2.forEach(System.out::println);


    }
}
