package com.comprehensive.practice.company.codility.test.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * int set[] = {1 ,2, 3};
 * output
 * { }
 * { 1 }
 * { 2 }
 * { 1 2 }
 * { 3 }
 * { 1 3 }
 * { 2 3 }
 * { 1 2 3 }
 */

public class CollectionOfAllSubset {

    public static void main(String[] args) {
        int[] set = {1, 2, 3};
        CollectionOfAllSubset collectionOfAllSubset = new CollectionOfAllSubset();
        List<List<Integer>> value = collectionOfAllSubset.getAllSubset(set);
        System.out.println(value);
    }



    public  List<List<Integer>> getAllSubset(int[] array){
        List<List<Integer>> superSet = new ArrayList<>();
        List<Integer> subset =new ArrayList<>();
        getAllSubset(superSet , subset, array ,0);
        return  superSet;
    }

    private void getAllSubset(List<List<Integer>> superSet, 
                              List<Integer> subset,
                              int[] array, 
                              int start) {
        superSet.add(new ArrayList<>(subset));
        for ( int i=start; i < array.length;i++){
            subset.add(array[i]);
            getAllSubset(superSet,subset,array,i+1);
            System.out.println(" subset :"+ subset + " i:" +1);
            subset.remove(subset.size() -1);
        }
    }

}
