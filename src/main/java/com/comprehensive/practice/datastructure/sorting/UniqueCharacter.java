package com.comprehensive.practice.datastructure.sorting;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueCharacter {
    public static void main(String[] args) {
        String      str= "euiewbfrEWYRCWEYRWI";

        boolean valuesss = str.chars().mapToObj(c -> Character.valueOf((char) c))
                .collect(Collectors.groupingBy(Function.identity(),  Collectors.counting()))
                .entrySet().stream().map(key -> key.getValue() > 1).count() >= 1;

        List<Character> sssss = str.chars().mapToObj(c -> Character.valueOf((char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(k -> k.getValue() > 1).map(k -> k.getKey())
                .collect(Collectors.toUnmodifiableList());
    }

    public static boolean isUniqueChars(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); ++i) {
            System.out.println(str.charAt(i));
            int val = str.charAt(i) - 'a';
            int tmp = checker & (1 << val);
            if (tmp > 0)
                return false;
            checker |= (1 << val);
        }
        return true;
    }

    public boolean getCharValue(String str){
        boolean[] charArr = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int currntVal = str.charAt(i);
            if(charArr[currntVal]==true){
                return false;
            }else {
                charArr[currntVal]=true;
            }
        }
        return true;
    }
}
