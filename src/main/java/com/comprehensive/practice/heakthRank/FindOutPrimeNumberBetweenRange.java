package com.comprehensive.practice.heakthRank;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindOutPrimeNumberBetweenRange {
    public static void main(String[] args) {
        List<Integer> ssss = IntStream.range(2, 100).filter(i -> isPrime(i)).boxed()
                .collect(Collectors.toList());
        System.out.println(ssss);
    }
    
    public static boolean isPrime(int n){
            for (int i = 2; i <=(int)Math.sqrt(n) ; i++) {
                if(n%i==0){
                    return false;
                }
            }
        return true;
    }
}
