package com.comprehensive.practice.company.codility.test.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetPr1 {
    public static void main(String[] args) {
        int[] set ={1,2,3};
       List<List<Integer>> superSet= getAllSebset(set);
        System.out.println(superSet);
    }

    private static List<List<Integer>> getAllSebset(int[] set) {
        List<List<Integer>> powerSet = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        constructAllSet(powerSet ,subset ,set ,0);
        return powerSet;
    }

    private static void constructAllSet(List<List<Integer>> powerSet,
                                        List<Integer> subset,
                                        int[] set, int idx) {
        powerSet.add(new ArrayList<>(subset));
        for (int i = idx; i < set.length; i++) {
            subset.add(set[i]);
            constructAllSet(powerSet ,subset ,set ,idx=idx+1);
            subset.remove(subset.size() -1 );
        }
    }


}
