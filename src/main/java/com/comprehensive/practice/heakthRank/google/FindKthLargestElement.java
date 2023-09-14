package com.comprehensive.practice.heakthRank.google;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Problem Statement: Given an unsorted array,
 * print Kth Largest and Smallest Element from an unsorted array.
 * Example 1:<br>
 * Input: Array = [1,2,6,4,5,3] , K = 3
 * Output: kth largest element = 4, kth smallest element = 3
 * <br>
 * Example 2:<br>
 * Input: Array = [1,2,6,4,5] , k = 3
 * Output : kth largest element = 4,  kth smallest element = 4
 * <br><br>
 * Solution 1: Sorting the Array
 * The most naive approach is to sort the given array in descending order.
 * The index of kth Largest element = k-1 ( zero-based indexing )
 * The index of kth Smallest element = n-k
 * The array can also be sorted in ascending order.
 * The index of kth Largest element = n-k
 * The index of kth Smallest element = k-1 ( zero based indexing )<br>
 * Time complexity: O(nlogn)<br>
 * Space complexity: O(1)
 * <br><br>
 * Solution 2: Using Heap
 * The idea is to construct a max-heap of elements. Since the top element of the max heap is the largest element of the heap, we will remove the top K-1 elements from the heap.  The top element will be Kth’s Largest element.
 * To get the Kth Smallest element, we will use a min-heap. After the removal of the top k-1 elements, the Kth Smallest element is top of the Priority queue.
 */
public class FindKthLargestElement {
    public static void main(String args[]) {
        int arr[] = {1, 2, 6, 4, 5, 3}  ;
        kth_Largest_And_Smallest_By_AscendingOrder(arr, 3) ;
    }

    static void kth_Largest_MaxHeap(int[] arr, int k) {
        PriorityQueue<Integer>pq= new PriorityQueue<>((a,b)->b-a);
        int n = arr.length  ;
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i])  ;
        }
        int f = k - 1 ;
        while (f > 0) {
            pq.remove()  ;
            f-- ;
        }
        System.out.println("Kth Largest element "+pq.peek())  ;
    }

    static void kth_Smallest_MinHeap(int[] arr, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int n = arr.length  ;
        for (int i = 0; i < n; i++) {
            pq.add(arr[i])  ;
        }
        int f = k - 1 ;
        while (f > 0) {
            pq.remove()  ;
            f-- ;
        }
        System.out.println("Kth Smallest element "+pq.peek())  ;
    }

    static void kth_Largest_And_Smallest_By_AscendingOrder(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        System.out.println("kth Largest element "+arr[n - k]+", "+
                "kth Smallest element "+arr[k - 1]);

        kth_Largest_MaxHeap(arr, 3)  ;
        kth_Smallest_MinHeap(arr, 3)  ;
    }
}


