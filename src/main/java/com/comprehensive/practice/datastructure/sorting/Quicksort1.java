package com.comprehensive.practice.datastructure.sorting;

public class Quicksort1 {

    static int[]  arr = {1,4,2,7,5,9,7};
    public static void main(String[] args) {
        quickSort(0 ,arr.length-1);
    }

    private static void quickSort(int low, int high) {
        if(low>high) return;
        int poivet = partition(low ,high);
        quickSort(low ,poivet -1);
        quickSort(poivet+1 ,high);
    }

    private static int partition(int low, int high) {
        int middleItem = (low+high)/2;
        // swap the pivot with the last item
        swap(middleItem, high);
        int i = low;

        for(int j=low;j<high;++j)  {
            if(arr[j]<=arr[high]) {
                swap(i,j);
                ++i;
            }
        }
        // swap back the pivot (middle item)
        swap(i, high);
        return i;
    }

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
