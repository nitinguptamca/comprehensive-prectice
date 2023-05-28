package com.comprehensive.practice.company.codility.test.easy;

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


    public static boolean checkSpecialChar(char  checkChar){
        return !Character.isAlphabetic(checkChar) ;
    }

}
