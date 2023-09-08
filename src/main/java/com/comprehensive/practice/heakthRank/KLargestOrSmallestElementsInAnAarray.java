package com.comprehensive.practice.heakthRank;

import java.util.Arrays;
import java.util.Collections;

public class KLargestOrSmallestElementsInAnAarray {

	// Standard partition process of QuickSort.
	// It considers the last element as pivot
	// and moves all smaller element to left of
	// it and greater elements to right
	public static int partition(Integer[] arr, int l, int r) {
		int x = arr[r], i = l;
		for (int j = l; j <= r - 1; j++) {
			if (arr[j] <= x) {
				// Swapping arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				i++;
			}
		}

		// Swapping arr[i] and arr[r]
		int temp = arr[i];
		arr[i] = arr[r];
		arr[r] = temp;

		return i;
	}

	// This function returns k'th smallest element
	// in arr[l..r] using QuickSort based method.
	// ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT
	public static int kthSmallest(Integer[] arr, int l, int r, int k) {
		// If k is smaller than number of elements
		// in array
		if (k > 0 && k <= r - l + 1) {
			// Partition the array around last
			// element and get position of pivot
			// element in sorted array
			int pos = partition(arr, l, r);

			// If position is same as k
			if (pos - l == k - 1)
				return arr[pos];

			// If position is more, recur for
			// left subarray
			if (pos - l > k - 1)
				return kthSmallest(arr, l, pos - 1, k);

			// Else recur for right subarray
			return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
		}

		// If k is more than number of elements
		// in array
		return Integer.MAX_VALUE;
	}

	public static void kLargest(Integer[] arr, int k) {
		// Sort the given array arr in reverse order
		// This method doesn't work with primitive data
		// types. So, instead of int, Integer type
		// array will be used
		Arrays.sort(arr, Collections.reverseOrder());

		// Print the first kth largest elements
		for (int i = 0; i < k; i++)
			System.out.print(arr[i] + " ");
	}

	/// **********************Best and easy********************************////
	public static void KLargestDemo(Integer[] array, int k) {

		if (k < 0 || k > array.length) {
			return;
		}
		int[] temp = new int[k];

		for (int i = k; i < array.length; i++) {
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for (int j = 0; j < temp.length; j++) {
				if (temp[j] < min) {
					min = temp[j];
					minIndex = j;
				}
			}
			if (array[i] > min) {
				temp[minIndex] = array[i];
			}
		}
		for (int i : temp) {
			System.out.print(i + " ");
		}
	}

	public static void kLargest2(Integer[] array, int k) {

		int minIndex = 0, i; // Find Min

		for (i = k; i < array.length; i++) {
			minIndex = 0;
			for (int j = 0; j < k; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
					array[minIndex] = array[j];
				}
			}
			if (array[minIndex] < array[i]) { // Swap item if min < array[i]

				int temp = array[minIndex];
				array[minIndex] = array[i];
				array[i] = temp;
			}
		}
		for (int q = 0; q < k; q++) { // Print output
			System.out.print(array[q] + " ");
		}
	}

	public static void main(String[] args) {
		Integer arr[] = new Integer[] { 1, 23, 12, 9, 30, 2, 50 };
		int k = 5;
		KLargestDemo(arr, k);
		kLargest2(arr, k);
		System.out.print("K'th smallest element is " + kthSmallest(arr, 0,
		 arr.length - 1, k));
	}

}
