package com.comprehensive.practice.mobikwik;

import java.util.Arrays;
import java.util.Comparator;

public class ExcelSheetNamingConvension {
   static char[] arrayChar = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public static void main(String[] args) {
      String str1 =getRemainingNumber(53);
        String   str  = new StringBuffer(str1).reverse().toString();
     String outPut="";
        for (int i = 0; i < str.length(); i++) {
           int j = Integer.parseInt(String.valueOf(str.charAt(i)));
           outPut += arrayChar[j -1 ];
        }
        System.out.println(outPut);
    }


   static String getRemainingNumber(int key) {
        String str="";
        int position=0;
        while(key>0) {
            int remainder = key % 26;
            str +=remainder;
            position++;
            key = key / 26;
        }
        return str;
    }
}
