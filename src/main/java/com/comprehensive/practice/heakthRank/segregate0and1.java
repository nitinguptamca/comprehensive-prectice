package com.comprehensive.practice.heakthRank;

//Segregate 0s and 1s in an array
public class segregate0and1 {

	/**
	 * Method for segregation 0 and 1 given input array
	 */
	static void segregate0and1(int arr[]) {
		int type0 = 0;
		int type1 = arr.length - 1;
		int count=0;
		while (type0 < type1) {
			--count;
			System.out.println(+count+  "   count  ");
			if (arr[type0] == 1) {
				// swap
				System.out.println(type1+"   type1  "+"arr[type1]  "+arr[type1] +"   arr[type0]  "+arr[type0] +"type0 "+type0);
				arr[type1] = arr[type1] + arr[type0];
				System.out.println("arr[type1]  "+type1+"  type1   "+arr[type1] +"   arr[type0]  "+arr[type0] +"type0 "+type0);
				arr[type0] = arr[type1] - arr[type0];
				System.out.println("arr[type1]  "+arr[type1] +"   arr[type0]  "+arr[type0]);
				arr[type1] = arr[type1] - arr[type0];
				System.out.println("arr[type1]  "+arr[type1] +"   arr[type0]  "+arr[type0]);
				type1--;
			} else {
				type0++;
			}
		}

	}

	static void segregate0and12(int arr[], int size) {
		/* Initialize left and right indexes */
		int left = 0, right = size - 1;

		while (left < right) {
			/* Increment left index while we see 0 at left */
			while (arr[left] == 0 && left < right)
				left++;

			/* Decrement right index while we see 1 at right */
			while (arr[right] == 1 && left < right)
				right--;

			/*
			 * If left is smaller than right then there is a 1 at left and a 0 at right.
			 * Exchange arr[left] and arr[right]
			 */
			if (left < right) {
				arr[left] = 0;
				arr[right] = 1;
				left++;
				right--;
			}
		}
	}

	// function to segregate 0s and 1s
	static void segregate0and1(int arr[], int n) {
		int count = 0; // counts the no of zeros in arr

		for (int i = 0; i < n; i++) {
			if (arr[i] == 0)
				count++;
		}

		// loop fills the arr with 0 until count
		for (int i = 0; i < count; i++)
			arr[i] = 0;

		// loop fills remaining arr space with 1
		for (int i = count; i < n; i++)
			arr[i] = 1;
	}

	// function to print segregated array
	static void print(int arr[], int n) {
		System.out.print("Array after segregation is ");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	// driver function
	public static void main(String[] args) {
		int arr[] = new int[] { 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 };
		int n = arr.length;
		segregate0and1(arr);
		// segregate0and12(arr, n);
		print(arr, n);

	}

}
