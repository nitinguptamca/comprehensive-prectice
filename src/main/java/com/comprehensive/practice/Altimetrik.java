package com.comprehensive.practice;

import java.util.Arrays;

/**
 * merge to sort array approach 1
 */

public class Altimetrik {
    static int[] num1={1,3,5,7,10};
    static int [] num2={2,4,6,8};

    public static void main(String[] args) {
        int[] output = new int[num1.length+ num2.length];
        int count=0;
        for (int i = 0; i < num1.length; i++) {
            output[count]=num1[i];
            count++;
        }
        for (int i = 0; i < num2.length; i++) {
            output[count]=num2[i];
            count++;
        }
        Arrays.sort(output);
        System.out.println(Arrays.toString(output));
    }

    public static int[] merge(int[] foo, int[] bar) {

        int fooLength = foo.length;
        int barLength = bar.length;

        int[] merged = new int[fooLength + barLength];

        int fooPosition, barPosition, mergedPosition;
        fooPosition = barPosition = mergedPosition = 0;

        while(fooPosition < fooLength && barPosition < barLength) {
            if (foo[fooPosition] < bar[barPosition]) {
                merged[mergedPosition++] = foo[fooPosition++];
            } else {
                merged[mergedPosition++] = bar[barPosition++];
            }
        }

        while (fooPosition < fooLength) {
            merged[mergedPosition++] = foo[fooPosition++];
        }

        while (barPosition < barLength) {
            merged[mergedPosition++] = bar[barPosition++];
        }

        return merged;
    }


}
