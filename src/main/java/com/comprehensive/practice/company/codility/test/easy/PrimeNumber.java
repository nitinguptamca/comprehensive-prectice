package com.comprehensive.practice.company.codility.test.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * get all primeNumber between 1 to 100
 */
public class PrimeNumber {
    public static void main(String[] args) {
        List<Integer>  listPrime= new ArrayList<>();
        for (int i = 2; i <= 100; i++) {
            if(isPrimeNumber(i)){
                listPrime.add(i);
            }
        }
        System.out.println(listPrime);
    }


   static public boolean isPrimeNumber(int number){
       int sqrtval =(int)Math.sqrt(number);
       for (int i = 2; i <=sqrtval; i++) {
           if(number%i==0){
               return false;
           }
       }
       return true;
    }
}
