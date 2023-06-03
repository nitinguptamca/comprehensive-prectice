package com.comprehensive.practice.coreJava;

public class TryCatchFinally {
    public static void main(String[] args) {
        TryCatchFinally tryCatchFinally = new TryCatchFinally();
        int value = tryCatchFinally.testing(5);
       //int value = tryCatchFinally.testing(0);
        System.out.println("value  ::"+value);
    }

    private int testing(int a) {
       try{
          return  1000/a;
       }catch (ArithmeticException e){
           System.out.println( e.getMessage());
           return 5;
       }finally {
           return  10;
       }
    }
}
