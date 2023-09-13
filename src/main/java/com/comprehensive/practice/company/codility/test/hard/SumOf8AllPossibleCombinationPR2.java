package com.comprehensive.practice.company.codility.test.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * problem statement We have sorted array find all possible combination of sum 8
 * like int[] sorted array ={-3,-2,-1,0,2,3,4,5,7,8,10,11} then possible
 * combination is {-3,11}{-2,10}{0,8}{3,5},{8},{-3,-2,-1,0,7,8} etc....}
 *
 * @author nitin
 */
public class SumOf8AllPossibleCombinationPR2 {
   static private int[] numbers = {1,9,6 ,-3,-2,-1,0,2,3,4,5,7,8,10,11};
    public static void main(String[] args) {
        List<List<Integer>> powerSet = new ArrayList<>();
        for (int i = 1; i < numbers.length; i++) {
            List<Integer> subset = new ArrayList<>();
            for(int  j=i ;j >=0 ; j--){
                subset.add(numbers[j] );
            }
            powerSet.add(subset);
        }

        List<List<Integer>> combinationof8 = new ArrayList<>();
        for (int i = 0; i < powerSet.size(); i++) {
            List<Integer> sublist = powerSet.get(i);
            int sum=0;
            for (int j = 0; j < sublist.size(); j++) {
                sum += sublist.get(j);
            }
            if (sum==8){
              combinationof8.add(sublist);
            }
        }

        System.out.println(combinationof8);
    }
}
