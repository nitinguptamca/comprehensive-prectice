package com.comprehensive.practice.java11;

import java.util.Arrays;

public class BucketSort {

    public int[] sort(int[] array, int min, int max) {
        int range = max - min +1;
        int[] result = new int[range];
        for (int i : array) {
            result[i]++;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] array = {1,6,4,3,3,6,4,4,3,1,6,3,4,8,7,8,6,4,4,2,2,3,5,7,7,7,
                4,3,9,2,2,6,9,8,8,7,6,5,5,4,3,3,2,2,2,3,3,2,3};
        int[] sort = new BucketSort().sort(array, 0, 9);
        for (int i = 0; i < sort.length; i++) {
            for(int j=0;j<sort[i];j++){
                System.out.println(i);
            }
        }
    }
}