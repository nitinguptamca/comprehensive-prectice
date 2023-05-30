package com.comprehensive.practice.company.codility.test.midium;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstRepeatingChar {
    public static void main(String[] args) {
        String findOutFirstRepeatingChar= "Nitin kumar gupta";
        Character value = findOutFirstRepeatingChar.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                )).entrySet().stream()
                .filter(e ->e.getValue()>1)
                .findFirst()
                .map(e -> e.getKey()).orElseGet(() -> '*');
        System.out.println(value);
    }
}
