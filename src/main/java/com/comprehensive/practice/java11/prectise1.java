package com.comprehensive.practice.java11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.util.Arrays.asList;

public class prectise1 {
    public static void main(String[] args) {
        String [] input = {"akka","akak","baab","baba","bbaa"};
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        prectise1 prectise1=new prectise1();
         List<String> list = new ArrayList<>(asList("first", "second", "third", "fourth"));
       // prectise1.unsafeMethod(list);
        prectise1.safeMethod(list);

    }

    public void unsafeMethod(List<String> list ) {
        for (String item : list) { // Will throw ConcurrentModificationException
            list.remove(item);
        }
    }
    public void safeMethod(List<String> list ) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) { // safe to call iterator.remove()
            String item = iterator.next();
            iterator.remove();
        }
    }
}
