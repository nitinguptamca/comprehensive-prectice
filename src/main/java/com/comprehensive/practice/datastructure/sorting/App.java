package com.comprehensive.practice.datastructure.sorting;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

       int[] num = {9, 1, 5, 2, 4, 3, 8, 7,6 ,0};

     ///   int[] nums = {99999, 111111, 55555, 22222, 44444, 33333, 88888, 7555556,};

      //  CountingSort sort = new CountingSort(nums1);
      ///  BogoSort sort = new BogoSort(nums1);
      ///  BubbleSort sort= new BubbleSort(nums1);

        //sort.sort();
       // bubbleSort(num);
        bucketSort(num);

        System.out.println(" display :  "+ Arrays.toString(num));
    }

    private static void bucketSort(int[] num) {
        int[] bucketArray = new int[10];
        for (int i = 0; i < num.length; i++) {
            bucketArray[num[i]]++;
        }

        int position = 0;
        for (int b = 0; b < bucketArray.length; b++)
            for (int c = 0; c < bucketArray[b]; c++)
                num[position++] = b;
    }

    public static void bubbleSort(int[] num){
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length-i-1; j++) {
                if(num[j] > num[j+1])
                    swap(j ,j+1 ,num);
            }

        }
    }
    public static void swap(int a ,int b ,int[] num){
        int temp =num[a];
        num[a] =num[b];
        num[b]=temp;
    }
}
