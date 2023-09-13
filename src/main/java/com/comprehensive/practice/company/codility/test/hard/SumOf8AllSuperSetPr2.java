package com.comprehensive.practice.company.codility.test.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * problem statement We have sorted array find all possible combination of sum 8
 * like int[] sorted array ={-3,-2,-1,0,2,3,4,5,7,8,10,11} then possible
 * combination is {-3,11}{-2,10}{0,8}{3,5},{8},{-3,-2,-1,0,7,8} etc....}
 *
 * @author nitin
 */
public class SumOf8AllSuperSetPr2 {
    public static void main(String[] args) {
        int[] numbers = {1,9,6 ,-3,-2,-1,0,2,3,4,5,7,8,10,11};
        Set<Set<Integer>> possibleCombinationOf8 = possibleCombinationof8List(numbers);
        System.out.println(possibleCombinationOf8);
    }

    private static Set<Set<Integer>> possibleCombinationof8List(int[] numbers) {
        List<List<Integer>> powerSet = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        possibleCombination(powerSet ,subset ,numbers ,0);
        Set<Set<Integer>> possibleCombinationOf8 = new HashSet<>();
        for (int i = 0; i < powerSet.size(); i++) {
            List<Integer> sublist = powerSet.get(i);
            int sum=0;
            for (int j = 0; j < sublist.size(); j++) {
                sum += sublist.get(j);
            }
            if (sum==8){
                possibleCombinationOf8.add(sublist.stream().collect(Collectors.toSet()));

            }
        }


        return possibleCombinationOf8;
    }

    private static void possibleCombination(List<List<Integer>> powerSet,
                                                           List<Integer> subset,
                                                           int[] numbers,
                                                           int idx) {
        powerSet.add(new ArrayList<>(subset));
        for (int j = idx; j < numbers.length; j++) {
            subset.add(numbers[idx]);
            possibleCombination(powerSet,subset,numbers ,idx=idx+1);
            subset.remove(subset.size() -1);
        }
    }
}
