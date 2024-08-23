package org.example.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise {

    public static void main(String[] args) {
//        List<List<Integer>> list = new ArrayList<>();
//        list.add(Arrays.asList(1, 2, 3));
//        list.add(Arrays.asList(4, 5));
//
//        List<List<Integer>> list2 = new ArrayList<>();
//        for (int i = 0; i< list.get(0).size(); i++) {
//            for (int j = 0; j< list.get(1).size(); j++) {
//                list2.add(Arrays.asList(list.get(0).get(i), list.get(1).get(j)));
//            }
//        }
//
//        list2.forEach(System.out::println);

        List<Integer> nums1 = Arrays.asList(1, 2, 3);
        List<Integer> nums2 = Arrays.asList(4, 5);

        List<List<Integer>> pairs = nums1.stream()
                .flatMap(i -> nums2.stream().map(j -> Arrays.asList(i, j)))
                .collect(Collectors.toList());

        System.out.println(Arrays.toString(pairs.toArray()));

    }
}
