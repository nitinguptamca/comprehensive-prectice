package com.comprehensive.practice.datastructure.map;

import java.util.Objects;

public class CustomMap<K extends Comparable<K>,V> {

    transient Node<K,V>[] table;
    int capacity;
    static class Node<K extends Comparable<K> ,V> {
        final K key;
        V value;
        Node<K,V> next;

        Node(K key, V value, Node<K,V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public String toString(){
            return  " key : "+key +" value :"+value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key) && Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    public CustomMap(int capacity) {
        this.capacity = capacity;
        this.table = new Node[capacity];
    }

    public void  put(K key ,V value){
        int hashCodeValue= getHashCode(key);
        Node<K,V> newNode = new Node<>(key,value,null);
        if(table[hashCodeValue]==null){
            table[hashCodeValue]=newNode;
        }else {
           Node<K,V>current = table[hashCodeValue];
           Node<K,V> previous=null;
           while (current!=null){
               if(current.key.compareTo(key)==0){
                   if(previous==null){
                        newNode.next=current.next;
                        table[hashCodeValue]=newNode;
                   }else {
                        newNode.next=current.next;
                        previous.next=newNode;
                   }
               }
                previous=current;
               current=current.next;
           }
           previous.next=newNode;
        }
    }

    public V get(K searchKey){
       int hashCodeValue= getHashCode(searchKey);
       Node<K,V> node =table[hashCodeValue];
       while (node!=null){
           if(node.key.compareTo(searchKey)==0)
               return node.value;;
           node=node.next;
       }
        return null;
    }

    public void remove(K searchKey){
        int hashCodeValue= getHashCode(searchKey);
        Node<K,V> previous =table[hashCodeValue];
        Node<K,V> current =previous;
        while(current!=null){
            Node<K,V> next =current.next;
            if(current.key.compareTo(searchKey)==0){
                if (previous == next) {
                    table[hashCodeValue] = next;
                } else {
                    previous.next = next;
                }
            }
            previous=current;
            current=next;
        }
    }

    private int getHashCode(K searchKey){
        return searchKey.hashCode()%capacity;
    }

    public void printAll(){
        Node<K,V>[] tmp =table ;
        for (int i = 0; i < tmp.length; i++) {
            Node<K,V> current=tmp[i];
            while(current!=null){
                System.out.print(current);
                current=current.next;
            }
            System.out.println();
        }
    }


}

class Testing{
    public static void main(String[] args) {
        CustomMap<Integer ,Integer> chm= new CustomMap<>(4);
        chm.put(1, 1);
        chm.put(2, 3);
        chm.put(3, 2);
        chm.put(4, 4);
        chm.put(5, 5);
        chm.put(6, 7);
        chm.put(7, 8);
        chm.put(8, 9);
        chm.put(13, 9);
        chm.put(18, 9);
        chm.put(23, 9);
        chm.put(9, 10);
        chm.printAll();
        System.out.println("***********************88");
        System.out.println(chm.get(1));
        System.out.println(chm.get(8));
        chm.remove(1);
        chm.remove(8);
        System.out.println();
        System.out.println(chm.get(1));
        System.out.println(chm.get(8));
        System.out.println(chm.get(3));
        System.out.println(chm.get(13));
        System.out.println(chm.get(18));
    }
}
