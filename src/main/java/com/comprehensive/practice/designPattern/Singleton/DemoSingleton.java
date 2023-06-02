package com.comprehensive.practice.designPattern.Singleton;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import java.lang.Runtime;

public class DemoSingleton implements Serializable {
    private static final long serialVersionUID = 1L;

    int count = 1;
    private DemoSingleton() {
       count +=100 ;
    }

    private static class DemoSingletonHolder {
        public static final DemoSingleton INSTANCE = new DemoSingleton();
    }

    public static DemoSingleton getInstance() {
        return DemoSingletonHolder.INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }

    @Override
    public String toString(){
        return  " count: "+count+ " memory location:: "+readResolve().hashCode();
    }
}

class Testing{
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        Runnable task = () -> {
            DemoSingleton instance = DemoSingleton.getInstance();
            System.out.println(instance);
        };
        for (int i = 0; i < 1000; i++) {
            executorService.submit(task);
        }
        executorService.awaitTermination(1 , TimeUnit.MINUTES);
        executorService.shutdown();

    }
}
