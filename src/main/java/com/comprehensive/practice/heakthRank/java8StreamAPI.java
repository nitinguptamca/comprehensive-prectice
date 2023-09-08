package com.comprehensive.practice.heakthRank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class java8StreamAPI {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,4,7,8,9,23,776,12,1343,56,8);
        list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

}
