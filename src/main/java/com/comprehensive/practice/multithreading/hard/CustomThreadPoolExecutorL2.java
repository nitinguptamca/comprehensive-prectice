package com.comprehensive.practice.multithreading.hard;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author nitingupta2
 * How will you write your own custom thread pool executor from scratch ?
 * <br>
 * <h1>Thread pool executor requires a Queue for holding tasks, and a collection of Worker Threads that will pick
 * up tasks from the work queue start running them. Let us try to write our own simple Thread Pool Executor
 * implementation.</h1>
 */
public class CustomThreadPoolExecutorL2 {
    private final BlockingQueue<Runnable> workerQueue;
    private final Thread[] workerThreads;

    class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }
        public void run() {
            while (true) {
                try {
                    workerQueue.take().run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void addTask(Runnable r) {
        try {
            workerQueue.put(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public CustomThreadPoolExecutorL2(int noOfThread) {
        this.workerQueue = new LinkedBlockingDeque<>();
        this.workerThreads = new Thread[noOfThread];
        for (int i = 0; i < noOfThread; i++) {
          Thread  t = new Worker("Custom Pool Thread " + ++i);
            t.start();
        }

    }

    public static void main(String[] args) {
        CustomThreadPoolExecutorL2 threadPoolExecutor = new CustomThreadPoolExecutorL2(10);
        threadPoolExecutor.addTask(() -> System.out.println("First print task"));
        threadPoolExecutor.addTask(() -> System.out.println("Second print task"));
        threadPoolExecutor.addTask(() -> System.out.println("Third print task"));
    }
}
