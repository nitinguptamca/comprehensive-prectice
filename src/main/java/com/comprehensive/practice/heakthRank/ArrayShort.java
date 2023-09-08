package com.comprehensive.practice.heakthRank;

/**
 *   repeating character not greater then 4
 * input str ="tuuuuuriiiiiinnnnngggsoooorttttt";
 * Output str="tuuuiiinnngggsooot"
 *
 * Exp2
 *
 * input s= "sdadfsdfsdfddddaatr"
 * output t="sdadfsdfsdfdddaatr"
 */
public class ArrayShort {
    public static void main(String[] args) {
        String str ="tuuuuuriiiiiinnnnngggsoooortttttsss";
        char[] charArr= str.toCharArray();
        int count=0;
        String str1 ="";
        for (int i = 0; i < charArr.length; i++) {
            if(i<=charArr.length-2 && charArr[i]==charArr[i+1] ){
                ++count;
                if(count<3){
                    str1+=String.valueOf(charArr[i]);
                }
            }else{
                count=0;
                str1+=String.valueOf(charArr[i]);
            }
        }
        System.out.println("str1:: "+ str1);
    }


}
