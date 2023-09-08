package com.comprehensive.practice.heakthRank;

import java.util.Arrays;

/**
 * int[] array = {1,2,3,4,5,6,7,8,9};
 * int[] output= {2,1,4,3,6,5,8,7,9}
 */
public class RearrangeOrder {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        int i=0;
        int l = array.length-1 ;
        while (i<l){
            if(i%2==0) {
                swap(i ,i+1 ,array);
            }
            i++;
        }
        System.out.println(Arrays.toString(array));
    }

    private static void swap( int i ,int j ,int[] array){
        int temp =  array[i];
        array[i]= array[j];
        array[j] = temp;
    }
}
