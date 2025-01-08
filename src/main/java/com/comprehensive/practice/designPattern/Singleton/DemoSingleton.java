package com.comprehensive.practice.designPattern.Singleton;

import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DemoSingleton implements Serializable {
    private static final long serialVersionUID = 1L;

    int count = 1;
    private DemoSingleton() {
       count +=new Random().nextInt();
    }

    private final  static class DemoSingletonHolder {
        private static final DemoSingleton INSTANCE = new DemoSingleton();
    }

    public static DemoSingleton getInstance() {
        return DemoSingletonHolder.INSTANCE;
    }

    protected Object readResolve() {
        return getInstance( );
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
