package com.comprehensive.practice.java11;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class OddNumberProblem {
    private int[] array = {1,1,2,3,4,5,2,3,4};
    public int findSingleOdd(){
        int result =0;
        for (int i : array) {
            result=result^i;
        }
        return result;
    }

    public static boolean checkOdd(long number){
        return ((number & 0x1) == 1);
    }
    public static void main(String[] args) {
        Map<String ,String>  map = new HashMap<>();
        map.put("a","a");
        methd1(map);
        System.out.println(map.size());
        Integer a=5 ,b =10;
        swap(a ,b);
        System.out.println(a+ "  "+b);

    }

    private static void swap(Integer a, Integer b) {
        Integer temp =a;
        a=b;
        b=temp;
    }

    private static void methd1(Map<String, String> map) {
        map.put("b","b");

    }
}