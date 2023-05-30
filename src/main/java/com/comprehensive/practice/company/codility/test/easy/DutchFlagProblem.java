package com.comprehensive.practice.company.codility.test.easy;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * The problem is that we want to sort a T[] one-dimensional array of integers in O(N) running time -
 * and without any extra memory.
 * The array can contain values: 0, 1 and 2 (check out the theoretical section for further information).
 * for example array like [1,2,2,1,2,1,0,1,0] after sorting [0,0,1,1,1,1,2,2,2]
 * inventor Edsger Dijkstra
 */
public class DutchFlagProblem {
    static int[] array = new int[]{2, 1, 2, 2, 1, 2, 1, 0, 1, 0};
    public static void main(String[] args) {
        sortThArray( array);
        System.out.println(Arrays.toString(array));
        Arrays.stream(array).sorted().boxed().collect(Collectors.toList());
    }

    private static void sortThArray(int[] array) {
        int i =0;
        int j =0;
        int k= array.length -1;
        while (j<=k){
            if(array[j]<1){
                swap(j ,i);
                j++;
                i++;
            } else if (array[j]>1) {
                swap(j ,k);
                k--;
            }else{
                j++;
            }
        }
    }
    private static void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
