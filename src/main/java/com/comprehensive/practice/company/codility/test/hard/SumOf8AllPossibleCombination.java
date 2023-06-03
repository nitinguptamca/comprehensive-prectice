package com.comprehensive.practice.company.codility.test.hard;

import java.util.*;
import java.util.stream.Collectors;

/**
 * problem statement We have sorted array find all possible combination of sum 8
 * like int[] sorted array ={-3,-2,-1,0,2,3,4,5,7,8,10,11} then possible
 * combination is {-3,11}{-2,10}{0,8}{3,5},{8},{-3,-2,-1,0,7,8} etc....}
 *
 * @author nitin
 */
public class SumOf8AllPossibleCombination {
   static private int[] numbers = {1,9,6 ,-3,-2,-1,0,2,3,4,5,7,8,10,11};
    public static void main(String[] args) {

        int target = 8;
       //  List<List<Integer>> value= process(numbers, target);
        //List<List<Integer>> value= combinationSum(numbers, target);
        //System.out.println(value);
        sortArray(numbers);
        System.out.println(Arrays.toString(numbers));
        printAllPossibleCombinationOfSum8(numbers ,8);

    }

  static   public void printAllPossibleCombinationOfSum8(int[] sortedArray ,int target){
      String possibleCombination = "";
      int begin;
      // int tmp = 0;
      int mid = 0;
      int end = sortedArray.length - 1;
      for (int i = 0; i < sortedArray.length; i++) {
          begin = i;
          mid = (begin + end) / 2;
          // tmp = sortedArray[begin] + sortedArray[mid];
          for (; (sortedArray[begin] + sortedArray[mid]) < 8; mid++)
              ;
          for (; ((mid > begin) && (sortedArray[begin] + sortedArray[mid]) > 8); mid--)
              ;
          if (sortedArray[begin] + sortedArray[mid] == 8) {
              possibleCombination += "{[" + sortedArray[begin] + "][" + sortedArray[mid] + "],";
              continue;
          }
      }

      System.out.println(" possible -->> " + possibleCombination);
    }

    private static void sortArray(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            for (int j = i; j >0 ; j--) {
                if(numbers[j-1] > numbers[j]){
                    swap(j-1 ,j);
                }
            }

        }
    }

    private static void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i]=numbers[j];
        numbers[j]= temp;
    }


    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, new ArrayList<>(), result, 0);
        return result;
    }

    private static void backtrack(int[] nums, int target, List<Integer> current, List<List<Integer>> result, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                current.add(nums[i]);
                backtrack(nums, target - nums[i], current, result, i);
                current.remove(current.size() - 1);
            }
        }
    }


    private static List<List<Integer>> process(Integer[] numbers,
                                               int target) {
        List<List<Integer>> superSet = new LinkedList<>();
        for (int i = 0; i < numbers.length; i++) {
            int sum = 0;
            for (int j = i; j < numbers.length; j++) {
                sum += numbers[j];
                if (sum == target) {
                    List<Integer> subList = new LinkedList<>();
                    for (int k = i; k <= j; k++) {
                        subList.add(numbers[k]);
                    }
                    superSet.add(subList);
                    System.out.println();
                }
                if ((numbers[i] + numbers[j]) == 8 && i != j) {
                    List<Integer> subList1 = new LinkedList<>();
                    subList1.add(numbers[i]);
                    subList1.add(numbers[j]);
                    superSet.add(subList1);
                }
            }
        }

    return superSet;
    }




}
