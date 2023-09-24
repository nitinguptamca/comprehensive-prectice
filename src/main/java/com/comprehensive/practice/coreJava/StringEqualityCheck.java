package com.comprehensive.practice.coreJava;

public class StringEqualityCheck {
    public static void main(String[] args) {
        String s = "java";
        Object o = s;
        String k =new String("java");
        if (o.equals(s)) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }
        if (s==o) {
            System.out.println("C");
        } else {
            System.out.println("D");
        }
        if(k.equals(s)){
            System.out.println("C");
        } else {
            System.out.println("D");
        }
        if(k==s){
            System.out.println("C");
        } else {
            System.out.println("D");
        }
    }
}
