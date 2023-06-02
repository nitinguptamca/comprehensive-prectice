package com.comprehensive.practice.company.codility.test.hard;

public class fibonacci {
    static int fib1(int n) {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
    public static int fib2(int n){
        return (n *(n+1))/2;
    }

    public static void main(String[] args) {
        System.out.println("\n Fibonacci "+fib1(10));
        System.out.println("\n Fibonacci2 "+fib2(10));
    }
}
