package com.comprehensive.practice.company.codility.test.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nitin
 * input String  "abc"
 * output String "cba"
 */

public class ReverseStringUsingRecursion {
    public static void main(String[] args) {
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
    }



