package com.comprehensive.practice.datastructure.map.pr1;

import com.comprehensive.practice.datastructure.map.CustomMap;

import java.util.Objects;

public class CustomHashMapPr1 <K extends Comparable<K> , V>{

    private final Entry <K,V> [] table ;
    private final int capacity;

    public CustomHashMapPr1( int capacity) {
        this.table = new Entry[capacity];
        this.capacity = capacity;
    }


    private static class Entry<K extends  Comparable<K> ,V>{
        K key;
        V value;
        Entry<K,V> next;
        Entry(K key ,V value , Entry<K,V> next){
            this.key=key;
            this.value=value;
            this.next=next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Entry)) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(key, entry.key) && Objects.equals(value, entry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        @Override
        public String toString(){
            return " key: "+key +"  value: "+value;
        }
    }

    public void put(K key ,V value){
        int hashCodeValue=getHashCode(key);
        if(table[hashCodeValue]==null){
            table[hashCodeValue]=new Entry<>(key ,value,null);
        }else {
          Entry<K,V> newNode=   new Entry<>(key ,value,null);
          Entry<K,V> currentElement= table[hashCodeValue];
          Entry<K ,V> previous=null;

          while(currentElement!=null){
              if(currentElement.key.compareTo(key)==0){
                  if(previous==null){
                      newNode.next=currentElement.next;
                      table[hashCodeValue]=newNode;
                  }else {
                      newNode.next=currentElement.next;
                      previous.next=newNode;
                  }
              }
              previous=currentElement;
              currentElement=currentElement.next;
          }
          previous.next=newNode;
        }
    }

    private int getHashCode(K key) {
        return key.hashCode()%capacity;
    }

}

class Testing{
    public static void main(String[] args) {
        CustomHashMapPr1<Integer ,Integer> chm= new CustomHashMapPr1<>(3);
        chm.put(1, 1);
        chm.put(2, 3);
        chm.put(3, 2);
        chm.put(4, 4);
        chm.put(1, 5);
        chm.put(2, 7);
        chm.put(7, 8);
        chm.put(8, 9);
        chm.put(13, 9);
        chm.put(18, 9);
        chm.put(23, 9);
        chm.put(9, 10);


    }
}
