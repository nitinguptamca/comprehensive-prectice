package com.comprehensive.practice.company.codility.java8.FlatMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  like Stream<String[]>
 *      or Stream<List<LineItem>>
 *          or Stream<Stream<String>>.
 */

public class FlatMapConcept {
    public static void main(String[] args) {
        List<Integer> even = Arrays.asList( 2, 4, 6, 8, 10);
        List<Integer> odd = Arrays.asList( 3, 5, 7, 9, 11);
        List<Integer> primes = Arrays.asList(17, 19, 23, 29, 31);

        List<List<Integer>> listOfNumbers = new ArrayList<>();
        listOfNumbers.add(even);
        listOfNumbers.add(odd);
        listOfNumbers.add(primes);

        List<Integer> flattenedList = listOfNumbers
                .stream()
                .flatMap(l -> l.stream())
                .collect(Collectors.toList());

        flattenedList = listOfNumbers
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        flattenedList = listOfNumbers
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        flattenedList=listOfNumbers
                .stream()
                .flatMap(s2 ->s2.stream())
                .collect(Collectors.toList());

        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        // Java 8
        String[] result = Stream.of(array)  // Stream<String[]>
                .flatMap(Stream::of)        // Stream<String>
                .toArray(String[]::new);

    }
}
