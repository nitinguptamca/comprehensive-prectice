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
        Integer[] set = {1, 2, 3};
        CollectionOfAllSubset collectionOfAllSubset = new CollectionOfAllSubset();
      //  List<List<Integer>> value = collectionOfAllSubset.getAllSubset(set);
        List<List<Integer>>   value =   collectionOfAllSubset.getAllSebSetGenericImpl(set);
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

    public <T>List<List<T>> getAllSebSetGenericImpl(T[] array){
        List<List<T>> superSet = new ArrayList<>();
        List<T> subSet = new ArrayList<>();
        getAllSebSetGenericImpl(superSet ,subSet ,array ,0);
        return superSet;
    }

    private <T> void getAllSebSetGenericImpl(List<List<T>> superSet,
                                             List<T> subSet,
                                             T[] array,
                                             int idx) {
        superSet.add(new ArrayList<>(subSet));
        for (int j = idx; j < array.length; j++) {
           subSet.add(array[j]);
           getAllSebSetGenericImpl(superSet ,subSet, array ,j+1);
           subSet.remove(subSet.size() -1);
        }
    }

}
