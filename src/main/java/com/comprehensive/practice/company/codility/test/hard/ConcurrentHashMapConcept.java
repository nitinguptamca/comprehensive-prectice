package com.comprehensive.practice.company.codility.test.hard;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <H1>ConcurrentHashMap is the Map implementation that allows us to modify the Map while iteration. The ConcurrentHashMap
 * operations are thread-safe. ConcurrentHashMap doesn't allow null for keys and values.</h1>
 * <h2>Signature of CHM<br>
 * public class ConcurrentHashMap<K,V> extends AbstractMap<K,V>
 *     implements ConcurrentMap<K,V>, Serializable {
 *     <br><br>
 *     ConcurrentHashMap map = new ConcurrentHashMap(int initialCapacity, float loadFactor, int concurrencyLevel)
 *
 *
 *     </h2>
 *     <br><br>
 * The table inside ConcurrentHashMap is divided among Segments (which extends Reentrant Lock), each
 * of which itself is a concurrently readable hash table. Each segment requires uses single lock to consistently
 * update its elements flushing all the changes to main memory
 * <h2> static class Segment<K,V> extends ReentrantLock implements Serializable { </h2>
 * <br>
 *
 * Iterator returned by the ConcurrentHashMap is fail-safe but weakly consistent. keySet().iterator() returns
 * the iterator for the set of hash keys backed by the original map. The iterator is a "weakly consistent" iterator
 * that will never throw ConcurrentModificationException, and guarantees to traverse elements as they existed
 * upon construction of the iterator, and may (but is not guaranteed to) reflect any modifications subsequent to
 * construction. Because its working on clone copy.
 *
 *
 * @param <K>
 * @param <V>
 */

/////https://medium.com/art-of-coding/hash-table-vs-concurrent-hashmap-and-its-internal-working-b28fc2725bdb
public class ConcurrentHashMapConcept<K,V> {
    // private transient Node<K,V>[] table;
    // private transient volatile Node<K,V>[] table;


///The segment in CHM is nothing but “a specialized hash table”.The default size is 16, meaning
// max 16 threads can work at a time.
//Each thread can work on each segment during high concurrency and at most 16 threads can
// operate at max which simply maintains 16locks to guard each bucket of the ConcurrentHashMap.
/*
    static final class Segment<K,V> extends ReentrantLock implements Serializable {
        // Implementations of methods like replace,clear,put etc.
        // Each such operation is handled by the particular Segment.
    }
    public V put(K key, V value) {
        Segment<K,V> s;
        // get the segment
      //  return s.put(key, hash, value, false); // calls the put method implemented in Segment (inner)class.
    }*/
    ///-------------------------------------
/*
    public V get(Object key) {
        Segment<K,V> s; // manually integrate access methods to reduce overhead
        HashEntry<K,V>[] tab;
        int h = hash(key.hashCode());
        long u = (((h >>> segmentShift) & segmentMask) << SSHIFT) + SBASE;
        if ((s = (Segment<K,V>)UNSAFE.getObjectVolatile(segments, u)) != null &&
                (tab = s.table) != null) {
            for (HashEntry<K,V> e = (HashEntry<K,V>) UNSAFE.getObjectVolatile
                    (tab, ((long)(((tab.length - 1) & h)) << TSHIFT) + TBASE);
                 e != null; e = e.next) {
                K k;
                if ((k = e.key) == key || (e.hash == h && key.equals(k)))
                    return e.value;
            }
        }
        return null;
    }

*/
/*
    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        volatile V val;
        volatile Node<K, V> next;
    }

    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {            return null;        }
        @Override
        public V getValue() {            return null;        }
        @Override
        public V setValue(V value) {            return null;        }
    }
    */
public static void main(String[] args) {
    Map<String ,String> map = new ConcurrentHashMap<>(10) ;
}

}

class ConcurrencyVerificationInConcurrentHashMap {

    public static Map<String,String> map = new ConcurrentHashMap<>();

    public static void iteratingMap() {
        map.put("Hello1","ConcurrentWorld");
        map.put("Hello2","ConcurrentWorld");
        map.put("Hello3","ConcurrentWorld");
        map.put("Hello4","ConcurrentWorld");
        map.put("Hello5","ConcurrentWorld");
        Iterator<String> iterate = map.keySet().iterator();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(iterate.hasNext()) {
            String key = iterate.next();
            System.out.println(map.get(key));
        }
    }
    public static void putMap() {
        for (int i = 0; i <10; i++) {
            map.put("Hello9"+i,"ConcurrentWorld"+i+"rwrwe");
        }

    }

    public static void main(String[] args) {
        int i=1 ;
        while(i<=10) {
            Thread thread1 = new Thread(
                    ConcurrencyVerificationInConcurrentHashMap::iteratingMap);
            Thread thread2 = new Thread(
                    ConcurrencyVerificationInConcurrentHashMap::putMap);
            thread2.start();
            thread1.start();
            i++;
        }
    }

}

class AtomicityVerificationInConcurrentHashMap {

    public static Map<String,Long> votingMachine = new ConcurrentHashMap<>();

    public static void polling() {
        for(int i=0; i< 1000;i++) {
            for (Map.Entry<String,Long> e : votingMachine.entrySet()) {
                long votes = votingMachine.get(e.getKey());
                votingMachine.put(e.getKey(),votes+1);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        votingMachine.put("TDP",0L);
        votingMachine.put("LSP",0L);
        votingMachine.put("YSRCP",0L);
        votingMachine.put("JSP",0L);
        votingMachine.put("OTHERS",0L);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=0; i<5; i++) {
            executorService.execute(AtomicityVerificationInConcurrentHashMap::polling);
        }
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.HOURS);

        System.out.println(votingMachine);
    }

}

class HashMapComparisions {

    public static Map<String,Integer> hashTable = new Hashtable<>();
    public static Map<String,Integer> normalMap = new HashMap<>();
    public static Map<String,Integer> synchronizedHashMap = Collections.synchronizedMap(normalMap);
    public static Map<String,Integer> concurrentHashMap = new ConcurrentHashMap<>();


    public static void performTest(Map<String,Integer> maptoEvaluateThePerformance) {
        for(int i=0; i<500000; i++) {
            Integer randomNumber = (int) Math.ceil(Math.random() * 550000);
            Integer value = maptoEvaluateThePerformance.get(String.valueOf(randomNumber));

            // Put value
            maptoEvaluateThePerformance.put(String.valueOf(randomNumber), randomNumber);
        }
    }
    public static void performMapWithSynchronizedTest(Map<String,Integer> maptoEvaluateThePerformance) {
        for(int i=0; i<500000; i++) {
            Integer randomNumber = (int) Math.ceil(Math.random() * 550000);
            synchronized (normalMap) {
                Integer crunchifyValue = maptoEvaluateThePerformance.get(String.valueOf(randomNumber));
            }
            synchronized (normalMap) {
                maptoEvaluateThePerformance.put(String.valueOf(randomNumber), randomNumber);
            }
        }
    }
    public static void evaluatingThePerformance(Map<String,Integer> maptoEvaluateThePerformance,int size) throws Exception {
        long averageTime = 0;
        for(int j=0; j<size;j++) {
            ExecutorService executorService = Executors.newFixedThreadPool(size);
            long startTime = System.nanoTime();
            for(int i=0; i<size;i++) {
                executorService.execute(()-> HashMapComparisions.performTest(maptoEvaluateThePerformance));
            }
            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
            long entTime = System.nanoTime();
            long totalTime = (entTime - startTime) / 1000000L;
            averageTime += totalTime;
            System.out.println("500K entried added/retrieved in " + totalTime + " ms");
        }
        System.out.println("For " + maptoEvaluateThePerformance.getClass() + " the average time is " + averageTime / 5 + " ms\n");
    }

    public static void evaluatingThePerformanceOfMapWithSynchronizedBlock(Map<String,Integer> maptoEvaluateThePerformance,int size) throws Exception {
        long averageTime = 0;
        for(int j=0; j<size;j++) {
            ExecutorService executorService = Executors.newFixedThreadPool(size);
            long startTime = System.nanoTime();
            for(int i=0; i<size;i++) {
                executorService.execute(()-> HashMapComparisions.performMapWithSynchronizedTest(maptoEvaluateThePerformance));
            }
            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
            long entTime = System.nanoTime();
            long totalTime = (entTime - startTime) / 1000000L;
            averageTime += totalTime;
            System.out.println("500K entried added/retrieved in " + totalTime + " ms");
        }
        System.out.println("For " + maptoEvaluateThePerformance.getClass() + "With SYNCHRONIZED BLOCKS the average time is " + averageTime / 5 + " ms\n");
    }

    public static void main(String[] args) throws Exception {
        evaluatingThePerformance(hashTable,5);
        evaluatingThePerformance(synchronizedHashMap,5);
        evaluatingThePerformance(concurrentHashMap,5);
        evaluatingThePerformanceOfMapWithSynchronizedBlock(normalMap,5);
    }

}



