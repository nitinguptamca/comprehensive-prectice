package com.comprehensive.practice.company.codility.test.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array, check if it contains a contiguous subarray having zero-sum.
 * <p>
 * Input : [3, 4, -7, 3, 1, 3, 1, -4, -2, -2]
 * Output: true
 * Explanation: The subarrays with zero-sum are
 * <p>
 * [3, 4, -7]
 * [4, -7, 3]
 * [-7, 3, 1, 3]
 * [3, 1, -4]
 * [3, 1, 3, 1, -4, -2, -2]
 * [3, 4, -7, 3, 1, 3, 1, -4, -2, -2]
 * <p>
 * Input : [4, -7, 1, 2, -1]
 * Output: false
 * Explanation: The subarray with zero-sum doesn't exist.
 */

public class SumZero {
    public static void main(String[] args) {
        int[] array =  {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        List<List<Integer>> ssss = getAllSumZero(array);
        System.out.println(ssss);
    }
    public static   List<List<Integer>> getAllSumZero(int[] array){
        List<List<Integer>> superSet = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            int sum =0;
            List<Integer> subset = new ArrayList<>();
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                if(sum==0){
                    subset.add(array[j]);
                    superSet.add(subset);
                    break;
                }else{
                    subset.add(array[j]);
                }
            }

        }
        return  superSet;
    }
}
