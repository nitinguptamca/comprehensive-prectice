package com.comprehensive.practice.company.codility.test.hard;

import java.util.Arrays;

/**
 * @author nitin
 * Input String str ="abc*&ktm$#@ptr";
 * OutPut String rev ="rtp*&mtk$#cba"
 */
public class ReverseStringExceptSpecialCharacter {
    public static void main(String[] args) {
        String str ="abc*&ktm$#@ptr";
        String ffff= reverseStringWithoutSpecialChar(str);
        System.out.println(ffff);
    }

    public static String reverseStringWithoutSpecialChar(final String str) {
        int len = str.length() - 1;
        char[] chars = str.toCharArray();
        int i = 0;

        while (i < len) {
            char firstCh = str.charAt(i);
            char lastCh = str.charAt(len);
            if (checkSpecialChar(firstCh)) {
                i++;
            } else if (checkSpecialChar(lastCh)) {
                len--;
            } else {
                char temp = chars[i];
                chars[i] = chars[len];
                chars[len] = temp;
                i++;
                len--;
            }
        }
        return String.copyValueOf(chars);
    }

    private static void swap(int i, int k) {
        char tmp = charsArr[k];
        charsArr[k]=charsArr[i];
        charsArr[i] =tmp;
    }

   static String str ="abc*&ktm$#@ptr";
  static   char[] charsArr= str.toCharArray();

    public static void main1(String[] args) {
        System.out.println("\n ************start **********");

        System.out.println(Arrays.toString(charsArr));
        int i = 0, j = 0, k = charsArr.length - 1;
        while (i <= k) {
            if (checkSpecialChar(charsArr[i])) {
                charsArr[i] = charsArr[i];
                i++;
            } else if (checkSpecialChar(charsArr[k])) {
                charsArr[k] = charsArr[k];
                k--;
            } else {
                swap(i, k);
                i++;
                k--;
            }
        }
        System.out.println("\n " + Arrays.toString(charsArr));
    }

    public static boolean checkSpecialChar(char  checkChar){
        return !Character.isAlphabetic(checkChar) ;
    }

}
