package com.comprehensive.practice.mobikwik.com;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Q2. You have a large text file [consider array of strings] containing words. Given any two words (w1, w2), find the
 * shortest distance (in terms of number of words) between them in the file.
 *
 * Sample I/P - “the quick the brown quick brown the frog”,
 * w1 = “quick”, w2 = “frog”  --2
 * w1 = “brone”, w2 = “frog”  --1
 * O/P -
 */

public class problem2 {
    public static void main(String[] args) {
        AtomicInteger index = new AtomicInteger();
        String input = "the quick the brown quick brown the frog";
        
        System.out.println("Min distance :: " + sortedDistanceBetweenWords("quick" ,"frog",input.split(" ")));

    }

    public static void main13(String[] args) {
        String input = "the quick the brown quick brown the frog";
        String[] arrStr= input.split(" ");
         int[] intArr ={1,4,4,7,9,8,3,5,5,7,8,2,3,8,-3,7,13,12,-9};
       //// System.out.println(ssss);
    }

    /**
     *Time Complexity: O(n)
     *Auxiliary Space: O(1)
     */
  static   public int sortedDistanceBetweenWords( String w1 , String w2, String[] strArray){
        if(w1.equals(w2)) return 0;
        int min_dist = (strArray.length) + 1;
        for (int i = 0; i < strArray.length; i++) {
            if(w1.equals(strArray[i])){
                for (int j = 0; j < strArray.length; j++) {
                    if(w2.equals(strArray[j])) {
                        int curr = Math.abs(i - j) - 1;
                        if (curr < min_dist) {
                            min_dist = curr;
                        }
                    }
                }
            }
        }
        return min_dist;
    }
}