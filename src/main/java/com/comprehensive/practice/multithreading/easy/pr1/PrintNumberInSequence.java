package com.comprehensive.practice.multithreading.easy.pr1;



public class PrintNumberInSequence {
    private int number;

    public void PrintEven (){
        synchronized (this) {
            while (number <11  ) {
                if (number % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(number);
                number++;
                notifyAll();
            }
        }
    }

    public void PrintOdd (){
        synchronized (this) {
            while (number < 11 ) {
                if (number % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                 }
                notifyAll();
                System.out.println(number);
                number++;
            }
        }
    }

    public static void main(String[] args) {
        PrintNumberInSequence printNumberInSequence = new PrintNumberInSequence();
        Thread t1 = new Thread(() ->{
                printNumberInSequence.PrintEven();
        });
        Thread t2 = new Thread(() ->{
            printNumberInSequence.PrintOdd();
        });
        t1.start();
        t2.start();
    }
}
