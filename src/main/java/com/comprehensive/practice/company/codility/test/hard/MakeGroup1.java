package com.comprehensive.practice.company.codility.test.hard;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MakeGroup1 {
    public static void main(String[] args) {
        //output a [apple,allow] ,b ["baba", "Babby"] , c["cat","caome"] , d["dog" ,"dobby"];

        String[] strArray = {"dog" ,"dobby", "cat","caome","apple","allow", "baba", "Babby" };
        List<String> list =Arrays.asList(strArray);
        Map<Character, String> ssss = list.stream().collect(Collectors.toMap(word -> word.charAt(0), word -> word,
                (s, a) -> s + ", " + a));
        System.out.println(ssss);
    }
}
