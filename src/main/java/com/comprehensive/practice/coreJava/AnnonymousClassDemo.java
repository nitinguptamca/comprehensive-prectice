package com.comprehensive.practice.coreJava;

abstract  class Abs1{
   abstract public void doSomthing();
}
public class AnnonymousClassDemo {
    public static void main(String[] args) {
        AnnonymousClassDemo annonymousClassDemo = new AnnonymousClassDemo();
        Abs1 abs1 = new Abs1() {
            @Override
            public void doSomthing() {
                System.out.println("nitin");
            }
        };
        abs1.doSomthing();
    }
}
