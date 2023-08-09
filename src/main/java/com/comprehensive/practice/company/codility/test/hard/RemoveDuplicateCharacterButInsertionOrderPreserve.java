package com.comprehensive.practice.company.codility.test.hard;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * String input="abcdefghjxabsadgerxkljdsafiy"
 * String output ="abcdefghjsrkli"
 * String str = "HFGDFGFJKJJJFTYERYVBCXFGDSUYUUNITINKHJFYTDXRSX";
 */
public class RemoveDuplicateCharacterButInsertionOrderPreserve {
    public static void main(String[] args) {
        String input = "abcdefghjxabsadgerxkljdsafiy";
        String removeDuplicate = input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(), LinkedHashMap::new, Collectors.counting()
                )).entrySet().stream().map(e -> e.getKey())
                .reduce("", (a, b) -> a + b, (s1, s2) -> s1 + s2);


        String ssss1111 = input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(), LinkedHashMap::new, Collectors.counting()
                )).entrySet().stream().map(e -> String.valueOf(e.getKey()))
                .collect(Collectors.joining());
        System.out.println("\n remove duplicate " + removeDuplicate);
        
        IntStream ssss1 = input.chars();
        Stream<Character> characterStream2
                = input.codePoints().mapToObj(c -> (char) c);
        Stream<String> stringStream = input.codePoints()
                .mapToObj(c -> String.valueOf((char) c));

    }


    private static String removeDuplicate(String str) {
        int tail = 0;
        char[] charArray = str.toCharArray();
        char[]  tmp = new char[charArray.length];
        boolean[] hit = new boolean[256];
        for (int i = 0; i < charArray.length; ++i) {
            char dsd = charArray[i];
            if (!hit[charArray[i]]) {
                tmp[tail] = charArray[i];
                ++tail;
                hit[charArray[i]] = true;
            }
        }
        String ssss="";
        for (int i = 0; i < tmp.length; i++) {
            if(tmp[i]=='\u0000') continue;
            ssss+=tmp[i];
        }
        return ssss;
    }
}
