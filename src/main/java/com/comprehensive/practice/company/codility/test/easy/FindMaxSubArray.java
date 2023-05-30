package com.comprehensive.practice.company.codility.test.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given an integer array, find the maximum sum among all its subarrays.
 * <p>
 * Input : [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * Output: 6
 * Explanation: The maximum sum subarray is [4, -1, 2, 1]
 * <p>
 * Input : [-7, -3, -2, -4]
 * Output: -2
 * Explanation: The maximum sum subarray is [-2]
 * <p>
 * Input : [-2, 2, -1, 2, 1, 6, -10, 6, 4, -8]
 * Output: 10
 * Explanation: The maximum sum subarray is [2, -1, 2, 1, 6] or [6, 4] or [2, -1, 2, 1, 6, -10, 6, 4]
 */
public class FindMaxSubArray {
    static int[]  Input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(findMaxSubarraySum(nums));
    }

    public static int findMaxSubarraySum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // calculate the sum of subarray `nums[i…j]`
            int sum = 0;    // reset sum
            // do for each subarray ending at `j`
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }
}
