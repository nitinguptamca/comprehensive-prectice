package com.comprehensive.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Integer[] intArr = {2,3,4,6,3,7,6,7,8,9};
 * //print the elements which are duplicate, by using stream api
 */
public class Testing {
    public static void main(String[] args) {
        String str = "anonmonkar";
        //print the index of non repeated first char
        char[] chrArray=str.toCharArray();
        int repeatCharIndex=getFirstRepeateChar(chrArray);
        System.out.println(repeatCharIndex);
    }

  static   public int getFirstRepeateChar(char[] chrArray){
        Set<Character> set = new HashSet<>();
        boolean flag=false;
        int count=0;
        for (int i = 0; i < chrArray.length; i++) {
            if(set.contains(chrArray[i])){
                set.add(chrArray[i]);
                flag =true;
            }else{
                set.add(chrArray[i]);
               if(flag) {
                   System.out.println(chrArray[i]);
                   count=i;
                   break;
               }
            }
        }
        return  count;
    }
}
