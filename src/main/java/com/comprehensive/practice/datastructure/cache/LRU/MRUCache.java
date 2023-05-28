package com.comprehensive.practice.datastructure.cache.LRU;

import java.util.HashMap;
import java.util.Map;

public class MRUCache <K extends Comparable<K> ,V> {

    private final Map<K , LRUCache.Node<K,V>> cache;
    private final int capacity;
    private LRUCache.Node<K,V> head ,tail;

    public MRUCache(int capacity){
        this.capacity=capacity;
        cache = new HashMap<>(capacity);
    }
    static class Node<K extends Comparable<K> ,V >{
        K key;
        V value;
        LRUCache.Node<K,V> next ,prev;
        Node(K key , V value){
            this.key=key;
            this.value=value;
        }
        public String toString(){
            return  " key: "+key +" value :"+value;
        }
    }

    public void put(K key ,V value){
        LRUCache.Node<K ,V> newNode = new LRUCache.Node<>(key, value);
        if(cache.containsKey(key)){
            LRUCache.Node<K,V> oldValue = getKey(key);
            delete(oldValue);
            addAtHead(newNode);
        }else {
            if(capacity >  cache.size()){
                addAtHead(newNode);
                cache.put(key ,newNode);
            }else {
                cache.remove(head.key);
                delete(head);
                addAtHead(newNode);
                cache.put(key,newNode);
            }
        }
    }

    public LRUCache.Node<K ,V> getKey(K key){
        if(cache.containsKey(key)) {
            return cache.get(key);
        }
        else return null;

    }

    public void addAtHead(LRUCache.Node<K ,V> node){
        if(head==null){
            head=tail=node;
        }else {
            LRUCache.Node<K, V> curernt = head;
            node.next = curernt;
            curernt.prev = node;
            head = node;
        }
    }

    public void delete(LRUCache.Node<K,V> node ){
        if(node.next==null){
            tail=node;
        }else if (node.prev==null){
            head=node;
        }else{
            LRUCache.Node<K,V> nodePrev= node.prev;
            LRUCache.Node<K,V> nodeNext=node.next;
            nodePrev.next=nodeNext;
            nodeNext.prev=nodePrev;
        }
    }
}
