package com.comprehensive.practice.heakthRank;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SecondHeightSalary {
    public static void main(String[] args) {
        Map<String, Integer> employees = new HashMap<>();
        employees.put("nitin", 1);
        employees.put("sachin", 2);
        employees.put("nitin1", 3);
        employees.put("sachin1", 4);
        employees.put("nitin4", 5);
        employees.put("sachin2", 6);
        employees.put("niti5", 7);
        employees.put("sachin2", 8);
        employees.put("nit6in", 9);
        employees.put("sachin3", 10);

        String ssss = employees.entrySet().stream()
                .sorted(Collections.reverseOrder( Map.Entry.comparingByValue()))
                .skip(1).findFirst().map(e -> e.getKey()).get();

        String sdsds = employees.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList())
                .get(1).getKey();

        Map<Integer, List<String>> sssqqqs = employees.entrySet().stream().collect(
                Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())));


        System.out.println(sssqqqs);


    }
}
