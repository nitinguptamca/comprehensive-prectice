package com.comprehensive.practice.heakthRank.google;

import java.util.HashSet;
import java.util.Set;

/**
 * Length of the longest substring without repeating characters<br>
 * Input: “ABCDEFGABEF”<br>
 * Output: 6 (The longest substring without repeating characters are “BDEFGA” and “DEFGAB”, with length 6)
 *<br>
 * Input: “GEEKSFORGEEKS”<br>
 * Output: 7 (The longest substring without repeating characters are ????KSFORG” and “KSFORGE”, with length 7)
 */
public class MaxNonRepeatingCharacter {
    public static void main(String[] args) {
        String input1= "ABCDEFGABEF";
        String input2= "ABCDEFGABEF";
        length_of_longest_substring(input1);
    }

  static   public boolean hasUniqueCharacters(String str ,int i ,int j){
        Set<Character> chars = new HashSet<>();
        for (int k = i; k <= j; k++) {
            char ch = str.charAt(i);
            if (chars.contains(ch)) {
                return false;
            }
            chars.add(ch);
        }
        return true;
    }

    public static int length_of_longest_substring(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (hasUniqueCharacters(s, i, j)) {
                    result = Math.max(result, j - i + 1);
                    System.out.println("sdfsdf"+s.substring(i ,j));
                }
            }
        }
        return result;
    }

}
