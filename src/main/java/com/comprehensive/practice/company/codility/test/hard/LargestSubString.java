package com.comprehensive.practice.company.codility.test.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestSubString {
    public static void main(String[] args) {
        String str= "abcdesaklhfqweirqiewljrlqkwehfqwyriowqdlskaj";
        String strss=getUniqueCharacterSubstringBruteForce(str);
        System.out.println(strss);

    }

   static String getUniqueCharacterSubstringBruteForce(String input) {
        String output = "";
        for (int start = 0; start < input.length(); start++) {
            Set<Character> visited = new HashSet<>();
            int end = start;
            for (; end < input.length(); end++) {
                char currChar = input.charAt(end);
                if (visited.contains(currChar)) {
                    break;
                } else {
                    visited.add(currChar);
                }
            }
            if (output.length() < end - start + 1) {
                output = input.substring(start, end);
            }
        }
        return output;
    }

  static   String getUniqueCharacterSubstring(String input) {
        Map<Character, Integer> visited = new HashMap<>();
        String output = "";
        for (int start = 0, end = 0; end < input.length(); end++) {
            char currChar = input.charAt(end);
            if (visited.containsKey(currChar)) {
                start = Math.max(visited.get(currChar)+1, start);
            }
            if (output.length() < end - start + 1) {
                output = input.substring(start, end + 1);
            }
            visited.put(currChar, end);
        }
        return output;
    }

    static public String reverseString(String str){
        return  str.chars().mapToObj(c ->(char)c)
                .reduce("",(a,b)->b+a,(s1,s2)->s2+s1);

    }

    public static int longestUniqueSubsttr(String str) {
        int n = str.length();
        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                if (areDistinct(str, i, j))
                    res = Math.max(res, j - i + 1);
        return res;
    }

    public static Boolean areDistinct(String str, int i, int j) {
        // Note : Default values in visited are false
        boolean[] visited = new boolean[26];
        for (int k = i; k <= j; k++) {
            if (visited[str.charAt(k) - 'a'] == true)
                return false;
            visited[str.charAt(k) - 'a'] = true;
        }
        return true;
    }

}
