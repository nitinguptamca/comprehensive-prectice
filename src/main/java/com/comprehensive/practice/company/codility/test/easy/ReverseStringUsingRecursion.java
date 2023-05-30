package com.comprehensive.practice.company.codility.test.easy;

import java.util.Stack;

/**
 * @author nitin
 * input String  "abc"
 * output String "cba"
 */

public class ReverseStringUsingRecursion {
    public static void main1(String[] args) {
        String str = "abc";
        StringBuilder sb  = new StringBuilder("");
        ReverseStringUsingRecursion recursion = new ReverseStringUsingRecursion();
        recursion.getReverseString(str, sb, str.length()-1);
        System.out.println("reverse:   "+ sb);
    }

    private void getReverseString(String str, StringBuilder sb, int idx) {
        if(idx>=0)
            getReverseString( str,  sb.append(str.charAt(idx)), idx-1);
        }

    public static void main(String[] args) {
         String  input = "abcd";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       // String reverseAlphabet = strrev(alphabet);
        String reverseAlphabet =recursiveHelper(alphabet ,0," ");
        System.out.println(reverseAlphabet);
    }

    public static String recursiveHelper(String strInput, int index, String output)
    {
        if(index == (strInput.length() - 1 ))
            output += strInput.charAt(index) + "";
        else
            output+= recursiveHelper(strInput, index + 1, output) +"";

        return output;
    }

    public static String strrev(String str) {
        return !str.equals("") ? strrev(str.substring(1)) + str.charAt(0) : str;
    }

   static String reverse(String stringToReverse, int index){
        if(index == 0){
            return stringToReverse.charAt(0) + "";
        }

        char letter = stringToReverse.charAt(index);
        return letter + reverse(stringToReverse, index-1);
    }

    public String reverseString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();

    }

    public static String reverse123(String str) {
        if ((null == str) || (str.length() <= 1)) {
            return str;
        }
        return reverse123(str.substring(1)) + str.charAt(0);
    }

}



