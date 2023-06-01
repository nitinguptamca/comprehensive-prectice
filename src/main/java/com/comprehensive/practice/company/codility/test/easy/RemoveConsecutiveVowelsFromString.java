package com.comprehensive.practice.company.codility.test.easy;


/**
 * Remove consecutive vowels from string
 * Given a string s of lowercase letters, we need to remove consecutive vowels from the string
 * Input: geeks for geeks
 * Output: geks for geks
 * <p>
 * Input : your article is in queue
 * Output : your article is in qu
 *
 *  static String input = "your article is in queue";
 *     static String expectedOutput = "yor article is in qu";
 *
 *     static String input1 = "youur artaeicle isau in queue";
 *     static String expectedOutput1 = "yor artacle isa in qu";
 */
public class RemoveConsecutiveVowelsFromString {
    public static void main(String[] args) {
        char[]  vowels = new char[]{'a','e','i','o','u'};
        String input ="geeks for geeks";

    }

    public void getStringRemoveConsecutiveVowels(String input){
        StringBuilder output= new StringBuilder();
        boolean flag =false;
        for (int i = 1; i < input.length(); i++) {
            String output1 = String.valueOf(input.charAt(i - 1));
            if(isVowel(input.charAt(i-1))  && isVowel(input.charAt(i)) ){
                if(!flag)
                    output.append(output1);
                flag=true;
            }else{
                if(!flag)
                    output.append(output1);
                flag=false;
            }
        }
        System.out.println(output);

    }

    public boolean isVowel(char c){
        return  c=='a'|| c=='e'||c=='i'||c=='o'||c=='u';
    }


}
