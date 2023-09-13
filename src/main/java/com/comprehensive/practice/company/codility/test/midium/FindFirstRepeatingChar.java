package com.comprehensive.practice.company.codility.test.midium;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindFirstRepeatingChar {
    public static void main(String[] args) {
        String findOutFirstRepeatingChar = "Nitin kumar gupta";
        Character value = findOutFirstRepeatingChar.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                )).entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .findFirst()
                .map(e -> e.getKey()).orElseGet(() -> '*');
        System.out.println(value);


        LinkedHashMap<Character, Long> ssssswwww = findOutFirstRepeatingChar.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));


    }
}
