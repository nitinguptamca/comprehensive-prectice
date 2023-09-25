package com.comprehensive.practice.mobikwik;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * input : int[] array = {8,-8,10,4,-6,9,-9,12,55,-30,2,5,6}
 * output k smallest and largest (ex k2 small -9 large 12)
 */
public class GetKLargeAndSmalllestElementFromArray {
    public static void main(String[] args) {
        int[] array = {8,-8,10,4,-6,9,-9,12,55,-30,2,5,6};
        int k=2;
        int smallest=Arrays.stream(array).boxed().sorted().skip(k-1).findFirst().orElseGet(()->Integer.MIN_VALUE);
        int largest=Arrays.stream(array).boxed().sorted(Collections.reverseOrder(Integer::compareTo)).skip(k-1).findFirst().orElseGet(() -> Integer.MAX_VALUE);
        System.out.println(smallest +" "+largest);

    }
}
