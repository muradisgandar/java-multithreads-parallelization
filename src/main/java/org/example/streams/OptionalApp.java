package org.example.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class OptionalApp {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        books.add(new Book("Being and Time", "Heidegger", 560, Type.PHILOSOPHY));
        books.add(new Book("The Trial", "Franz Kafka", 240, Type.NOVEL));
        books.add(new Book("Death on The Nile", "Agatha Christie", 370, Type.THRILLER));
        books.add(new Book("Ancient Greece", "Robert F.", 435, Type.HISTORY));
        books.add(new Book("Ancient Rome", "Robert F.", 869, Type.HISTORY));
        books.add(new Book("Death of Virgil", "Hermann Broch", 590, Type.NOVEL));
        books.add(new Book("The Stranger", "Albert Camus", 560, Type.NOVEL));

        // total number of books
//        System.out.println(books.stream().count());

        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        // we don't want to get NullPointerException
        nums.stream().reduce(Integer::max).ifPresent(System.out::println);

        // the nax number of pages
        books.stream().map(Book::getPages).reduce(Integer::max).ifPresent(System.out::println);

        // we want to get longest book
        books.stream().max(Comparator.comparing(Book::getPages)).ifPresent(System.out::println);
        books.stream().reduce((b1, b2) -> b1.getPages() > b2.getPages() ? b1 : b2).ifPresent(System.out::println);

        // sum all pages
        books.stream().map(Book::getPages).reduce(Integer::sum).ifPresent(System.out::println);
        books.stream().mapToInt(Book::getPages).max().ifPresent(System.out::println);

        // allMatch() - checking if a Predicate matches all elements
        boolean result = books.stream().allMatch(b -> b.getPages() > 2000);
        System.out.println(result);

        // noneMatch() - opposite of allMatch
        boolean result2 = books.stream().noneMatch(b -> b.getPages() > 2000);
        System.out.println(result2);

        // findAny() - returns arbitrary element
        books.stream().filter(b-> b.getType() == Type.FICTION).findAny().ifPresent(System.out::println);

    }
}
