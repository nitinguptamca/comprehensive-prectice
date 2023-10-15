package com.comprehensive.practice.Array;

import java.util.Arrays;

/**
 * Smallest 3 element
 */

public class FindSmallest3element {
    public static void main(String[] args) {
        int[][]   array = {
                {10,20,30,40},
                {20,11,67,13},
                {44,12,23,43}
        };
       int smallest3=Arrays.stream(array).flatMapToInt(l ->Arrays.stream(l)).boxed().sorted().skip(2).findFirst().get();
        System.out.println(smallest3);

    }
}
