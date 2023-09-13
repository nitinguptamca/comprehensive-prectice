package com.comprehensive.practice.company.codility.test.hard;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Testing123 {
    public static void main(String[] args) {
        String str="nitin neetu sachin apple orange bad body arrow cat copy dog drone eye dare";
        LinkedHashMap<Character, String> sss = Arrays.stream(str.split(" "))
                .collect(Collectors.toMap(w -> w.charAt(0), w -> w, (o1, o2) -> o1 + " "+o2, LinkedHashMap::new));
        Map<Character, List<String>> sssss = Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(a -> a.charAt(0)));

        System.out.println(sss);
    }
}
