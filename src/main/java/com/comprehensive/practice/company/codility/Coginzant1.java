package com.comprehensive.practice.company.codility;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Coginzant1 {
    public static void main(String[] args) {
        int[] array ={1,3,5,8,2,8,13,16,29,30,98,1};
       int min= Arrays.stream(array).boxed().sorted().findFirst().get();
      int max=  Arrays.stream(array).boxed().sorted(Collections.reverseOrder(Integer::compareTo)).findFirst().get();
        System.out.println(min + " "+max);
        String[] strArr= {"aa","nitin","bb","saut","cc","aa"};
        String duplicate =Arrays.stream(strArr)
                .collect(Collectors.groupingBy( Function.identity() , Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue()>1).findFirst().map(Map.Entry::getKey).get();
        System.out.println(duplicate);

        String findLargest =Arrays.stream(strArr).sorted((a ,b) -> {
              if(a.length() < b.length()) return 1;
              else if (a.length() > b.length()) return -1;
               else return 0   ;
              }).findFirst().get();

        System.out.println(findLargest);

        ExecutorService executorService = new ThreadPoolExecutor(10 ,10 ,
                10L, TimeUnit.SECONDS , new LinkedBlockingDeque<>());

                Executors.newFixedThreadPool(10);




    }
}
