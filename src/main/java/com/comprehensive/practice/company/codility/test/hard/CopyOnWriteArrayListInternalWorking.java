package com.comprehensive.practice.company.codility.test.hard;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <h1>CopyOnWriteArrayList is a thread-safe variant of ArrayList where operations
 * which can change the ArrayList (add, update, set methods) creates a clone of the
 * underlying array. CopyOnWriteArrayList is to be used in a Thread based environment where read operations are very
 * frequent and update operations are rare.
 * <br><br>
 * whole content of the CopyOnWriteArrayList is copied into the new internal copy.
 * <br><br>
 * Removing While Iterating Is Not Allowed
 * </h1>
 *
 * <br><br>
 * <h3>Its content is an exact copy of data that is inside an ArrayList from the time when the Iterator was created. Even if in the meantime some other thread adds or removes an element from the list, that modification is making a fresh copy of the data that will be used in any further data lookup from that list.</h3>
 */
public class CopyOnWriteArrayListInternalWorking {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> numbers
                = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 8});
        Iterator<Integer> iterator = numbers.iterator();
        numbers.add(10);
        List<Integer> result2 = new LinkedList<>();
        result2.add(20);
        iterator.forEachRemaining(result2::add);


        while (iterator.hasNext()) {
            numbers.add(10);
            System.out.println(iterator.next());
        }
    }
}
