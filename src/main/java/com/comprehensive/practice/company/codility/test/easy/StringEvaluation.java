package com.comprehensive.practice.company.codility.test.easy;

public class StringEvaluation {

    public static void main(String[] args) {
        StringEvaluation stringEvaluation= new StringEvaluation();
        stringEvaluation.checkString();
    }

    private void checkString() {
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1==s2);
        String s3= "abc";
        System.out.println(s1==s3);
        String s4= "abc";
        System.out.println(s3==s4);
        s4= s1;
        System.out.println(s3==s4);


    }
}
