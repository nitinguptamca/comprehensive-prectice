package com.comprehensive.practice.Coginzant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Write a program t find out list of combination of numbers in array of numbers whose summation will be 18
 */
public class Combination18 {
    public static void main(String[] args) {
        int[] array ={-3,-1,-5,7,4,3,2,9};
        List<List<Integer>> resultSum8 = combination18(array);
        System.out.println(resultSum8.size());
        System.out.println(resultSum8);
    }

    private static List<List<Integer>> combination18(int[] array) {
        List<List<Integer>> powerSet= new ArrayList<>();
        List<Integer> subset= new ArrayList<>();
        allCombination(powerSet ,subset,array ,0);
        List<List<Integer>> result= new ArrayList<>();
        for(List<Integer> outer: powerSet){
         int count=   outer.stream().reduce(0 ,(a,b) -> a+b);
         if(count==18) result.add(outer);
        }
        return result;
    }

    private static void allCombination(List<List<Integer>> powerSet, List<Integer> subset, int[] array, int start) {
        powerSet.add(new ArrayList<>(subset));
        for (int j = start; j < array.length; j++) {
            subset.add(array[j]);
            allCombination(powerSet, subset, array, j+1);
            subset.remove(subset.size() -1);
        }
    }
}
