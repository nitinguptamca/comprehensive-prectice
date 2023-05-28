package com.comprehensive.practice.datastructure.cache.LRU;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LRUCache <K extends Comparable<K> ,V >{
    private final Map<K ,Node<K,V>> cache;
    private final int capacity;
    private Node<K,V> head ,tail;

    public LRUCache(int capacity){
        this.capacity=capacity;
        cache = new HashMap<>(capacity);
    }
    static class Node<K extends Comparable<K> ,V >{
        K key;
        V value;
        Node<K,V> next ,prev;
        Node(K key , V value){
            this.key=key;
            this.value=value;
        }
        public String toString(){
            return  " key: "+key +" value :"+value;
        }
    }

    public void put(K key ,V value){
        Node<K ,V> newNode = new Node<>(key, value);
        if(cache.containsKey(key)){
            Node<K,V> oldValue = getKey(key);
            delete(oldValue);
            addAtHead(newNode);
        }else {
            if(capacity >  cache.size()){
                addAtHead(newNode);
                cache.put(key ,newNode);
            }else {
                cache.remove(tail.key);
                delete(tail);
                addAtHead(newNode);
                cache.put(key,newNode);
            }
        }
    }

    public Node<K ,V> getKey(K key){
        if(cache.containsKey(key)) {
            return cache.get(key);
        }
        else return null;

    }

    public void addAtHead(Node<K ,V> node){
        if(head==null){
            head=tail=node;
        }else {
            Node<K, V> curernt = head;
            node.next = curernt;
            curernt.prev = node;
            head = node;
        }
    }

    public void delete(Node<K,V> node ){
        if(node.next==null){
            tail=node;
        }else if (node.prev==null){
            head=node;
        }else{
            Node<K,V> nodePrev= node.prev;
            Node<K,V> nodeNext=node.next;
            nodePrev.next=nodeNext;
            nodeNext.prev=nodePrev;
        }
    }
}

class Testing{
    public static void main(String[] args) {
        LRUCache<String ,UserSession> userList= new LRUCache<>(3);
        int count=0;
        for (int i = 0; i < 10; i++) {
            UUID currentUser = UUID.randomUUID();
            String key ="nitin"+count;
            if(i%3==0){
                count=2;
                userList.put( key,
                        new UserSession(currentUser, LocalDateTime.now(), LocalDateTime.now(), 0L, "nitin"+currentUser ));
            }else{
                count++;
                userList.put(key ,
                        new UserSession(currentUser, LocalDateTime.now(), LocalDateTime.now(), 0L, "nitin" +i));
            }
            System.out.println(userList.getKey(key));
        }


    }

}
