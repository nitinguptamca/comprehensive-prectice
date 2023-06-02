package com.comprehensive.practice.company.codility.test.hard;

/**
 * Find out first not repeating sub string
 * String s ="abcabcbb"
 * Expected answer is "abc";
 */
public class FindOutFirstNotRepeatingSubstring {

    public static void main(String[] args) {
      String longestSubString ="";
      String s= "abcabcbb";
      String str="";
       mainLoop:
        for (int i = 0; i < s.length(); i++)
            for (int j = i + 1; j < s.length(); j++) {
                String current = s.substring(i, j);
                String reverseStr = new StringBuffer(current).reverse().toString();
                if (current.length() == 1) longestSubString = current;
                else if (longestSubString.length() < current.length()
                        && current.charAt(0) != reverseStr.charAt(0)) longestSubString = current;
                else break mainLoop;
            }

        System.out.println(longestSubString);
    }
}
