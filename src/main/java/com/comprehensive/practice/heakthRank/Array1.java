package com.comprehensive.practice.heakthRank;

import java.util.Arrays;

//find out for away for Zero 0 in negative and positive both case
// which distance is height.
public class Array1 {
    public static void main(String[] args) {
        int[] array = {-11 ,23,45,-23,1,4,56,7,-58};
        Arrays.sort(array);
        int a = array[array.length-1] > -array[0]? array[array.length-1]:array[0] ;
        System.out.println(a);
    }
}
