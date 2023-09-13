package com.comprehensive.practice.company.codility.test.easy;

public class RemoveConsecutiveVovelsFromStringPr1 {
    public static void main(String[] args) {
        String s = "sffaadfsdsiiijdsooosdfksllsuuu";
        char[] ssssss=s.toCharArray();
        String output ="";
        boolean flag =false;
        for (int i = 1; i < ssssss.length; i++) {
            if((ssssss[i-1]==ssssss[i])&& isVowel(ssssss[i])){
                if(!flag)
                output += String.valueOf(ssssss[i]);
                flag=true;
            }
        }

    }

    static  public boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'|| ch==' ';
    }
}
