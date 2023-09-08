package com.comprehensive.practice.heakthRank;

public class MaximumDifferenceBetweenTwoElements {

	/*
	 * The function assumes that there are at least two elements in array. The
	 * function returns a negative value if the array is sorted in decreasing order.
	 * Returns 0 if elements are equal
	 */
	static int maxDiff(int arr[], int arr_size) {
		int max_diff = arr[1] - arr[0];
		int i, j;
		for (i = 0; i < arr_size; i++) {
			for (j = i + 1; j < arr_size; j++) {
				if (arr[j] - arr[i] > max_diff)
					max_diff = arr[j] - arr[i];
			}
		}
		return max_diff;
	}

	/*
	 * The function assumes that there are at least two elements in array. The
	 * function returns a negative value if the array is sorted in decreasing order.
	 * Returns 0 if elements are equal
	 */
	static int maxDiff1(int arr[], int arr_size) {
		int max_diff = arr[1] - arr[0];
		int min_element = arr[0];
		int i;
		for (i = 1; i < arr_size; i++) {
			if (arr[i] - min_element > max_diff)
				max_diff = arr[i] - min_element;
			if (arr[i] < min_element)
				min_element = arr[i];
		}
		return max_diff;
	}

	static int maxDiff3(int arr[], int n) {
		// Create a diff array of size n-1. The array will hold
		// the difference of adjacent elements
		int diff[] = new int[n - 1];
		for (int i = 0; i < n - 1; i++)
			diff[i] = arr[i + 1] - arr[i];

		// Now find the maximum sum subarray in diff array
		int max_diff = diff[0];
		for (int i = 1; i < n - 1; i++) {
			if (diff[i - 1] > 0)
				diff[i] += diff[i - 1];
			if (max_diff < diff[i])
				max_diff = diff[i];
		}
		return max_diff;
	}
	
	static void UnionArray(int arr1[], int arr2[]) {
		// Taking max element present in either array
		int m = arr1[arr1.length - 1];
		int n = arr2[arr2.length - 1];

		int ans = 0;

		if (m > n) {
			ans = m;
		} else
			ans = n;

		// Finding elements from 1st array
		// (non duplicates only). Using
		// another array for storing union
		// elements of both arrays
		// Assuming max element present
		// in array is not more than 10^7
		int newtable[] = new int[ans + 1];

		// First element is always
		// present in final answer
		System.out.print(arr1[0] + " ");

		// Incrementing the First element's count
		// in it's corresponding index in newtable
		++newtable[arr1[0]];

		// Starting traversing the first
		// array from 1st index till last
		for (int i = 1; i < arr1.length; i++) {
			// Checking whether current element
			// is not equal to it's previous element
			if (arr1[i] != arr1[i - 1]) {
				System.out.print(arr1[i] + " ");
				++newtable[arr1[i]];
			}
		}

		// Finding only non common
		// elements from 2nd array
		for (int j = 0; j < arr2.length; j++) {
			// By checking whether it's already
			// present in newtable or not
			if (newtable[arr2[j]] == 0) {
				System.out.print(arr2[j] + " ");
				++newtable[arr2[j]];
			}
		}
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {

		int arr[] = { 1, 2, 90, 10, 110, 89 };
		 int arr1[] = {1, 2, 2, 2, 3};
	        int arr2[] = {2, 3, 4, 5};
	         
	        UnionArray(arr1, arr2);
		
		System.out.println("Maximum differnce is " + maxDiff1(arr, 6));
	}
}
