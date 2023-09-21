package com.comprehensive.practice.mobikwik.com;

import java.util.Arrays;

/**
 * Q1. Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position,
 * Print the max value sliding window.
 * Input: vals = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output:
 * Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
 * Output: 3 3 4 5 5 5 6
 * Explanation: Maximum of 1, 2, 3 is 3
 *                        Maximum of 2, 3, 1 is 3
 *                        Maximum of 3, 1, 4 is 4
 *                        Maximum of 1, 4, 5 is 5
 *                        Maximum of 4, 5, 2 is 5
 *                        Maximum of 5, 2, 3 is 5
 *                        Maximum of 2, 3, 6 is 6
 *
 * Soln- answer  [1,3,-1,-3,5,3,6,7], and k = 3   ANS[3,3,5,5,6,7]
 * TC-
 * SC-
 */
public class problem1 {
    // Method to find the maximum for
    // each and every contiguous
    // subarray of size K.
    static void printKMax(int arr[], int N, int K)
    {
        for (int i = 0; i <= N - K; i++) {
          int  max = arr[i];
            for (int j = 1; j < K; j++) {
                if (arr[i + j] > max)
                    max = arr[i + j];
            }
            System.out.print(max + " ");
        }
    }

    static public int[] SlidingWindowMaximum(int[] A, int K, int[] nums) {
        int n = nums.length;
        if (n * K == 0) return new int[0];
        int [] output = new int[n - K + 1];

        for (int i = 0; i < n - K + 1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + K; j++)
                max = Math.max(max, A[j]);
            output[i] = max;
        }
        return output;
    }

    // Driver's code
    public static void main(String args[])
    {
        int arr[] = { 1,3,-1,-3,5,3,6,7 };
        int K = 3;
        // Function call
        printKMax(arr, arr.length, K);
       int[] ssssss= SlidingWindowMaximum(arr,3,arr);
        System.out.println(Arrays.toString(ssssss));
    }
}
