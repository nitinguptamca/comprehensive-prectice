package com.comprehensive.practice.company.codility.test.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Fail Fast And Fail Safe Iterators in Java
 *
 * Iterators in java are used to iterate over the Collection objects.Fail-Fast iterators immediately throw ConcurrentModificationException if there is structural modification of the collection. Structural modification means adding, removing any element from collection while a thread is iterating over that collection. Iterator on ArrayList, HashMap classes are some examples of fail-fast Iterator.
 * Fail-Safe iterators don’t throw any exceptions if a collection is structurally modified while iterating over it. This is because, they operate on the clone of the collection, not on the original collection and that’s why they are called fail-safe iterators. Iterator on CopyOnWriteArrayList, ConcurrentHashMap classes are examples of fail-safe Iterator.
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List<Integer> sss = new ArrayList<>();
        sss.add(1);
        sss.add(2);
        sss.add(4);

        for (Integer a:sss ) {
            if(a==1){
                // sss.add(3);  //java.util.ConcurrentModificationException
                sss.remove(1);  //java.util.ConcurrentModificationException
            }
            // sss.remove(20);
        }
        System.out.println(sss);
    }
}
