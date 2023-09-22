package com.comprehensive.practice.mobikwik;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * input  List<Integer> list = Arrays.asList(2,3,2,2,5,5,6,5,7,5,3,1);
 * output  555522233671
 */
public class problem4 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,3,2,2,5,5,6,5,7,5,3,1);
       list.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting())) ///Map<5 ,4>
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Long::compareTo))
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(e ->{
                    for (int i = 0; i < e.getValue(); i++) {
                        System.out.print(e.getKey());
                    }
                });


        list.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting())) ///Map<5 ,4>
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .iterator( );


    }
}
