package com.comprehensive.practice.company.codility.test.easy;

import java.util.Arrays;
import java.util.Objects;

public class AnagramTest {
    public static void main(String[] args) {
        String s1="abcdef";
        String s2 ="fedcba";
      //  System.out.println(isAnagram(s1 ,s2));
        char[] a1 = s1.toCharArray();
        char[] a2 =s2.toCharArray();
        insertionSort(a1);
        insertionSort(a2);
        System.out.println(Arrays.equals(a1,a2));
        System.out.println(isAnagramApproach2( s1 ,  s2));
    }

    static void insertionSort(char[] charArr){
        for (int i = 0; i < charArr.length -1 ; i++) {
            for (int j = i+1; j > 0; j--) {
                    if(charArr[j-1] > charArr[j] )
                        swap( j-1 ,j , charArr);
            }
        }
    }

    private static void swap(int i, int j, char[] charArr) {
        char temp = charArr[i];
        charArr[i] =charArr[j];
        charArr[j]=temp;
    }

    static public boolean isAnagram(String s1 ,String s2){
        if(s1.length()!=s2.length()) return false;
        else {
            int count =0;
            int length=s2.length()-1;
            while (count< s1.length()){
                if(s1.charAt(count)!=s2.charAt(length-count)){
                    return false;
                }
                count ++;
            }
        }
        return true;
    }

  static   public boolean isAnagramApproach2(String s1 , String s2){
      int CHARACTER_RANGE= 256;
      if (s1.length() != s2.length()) {
          return false;
      }
      int count[] = new int[CHARACTER_RANGE];
      for (int i = 0; i < s1.length(); i++) {
          count[s1.charAt(i)]++;
          count[s2.charAt(i)]--;
      }
      for (int i = 0; i < CHARACTER_RANGE; i++) {
          if (count[i] != 0) {
              return false;
          }
      }
      return true;

    }

}
