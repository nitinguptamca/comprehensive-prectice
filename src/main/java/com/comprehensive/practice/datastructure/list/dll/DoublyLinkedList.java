package com.comprehensive.practice.datastructure.list.dll;

import java.util.Objects;

public class DoublyLinkedList<T extends Comparable<T>> {
    Node<T> head,tail;
    static class Node<T extends Comparable<T>>{
        T data;
        Node<T> next ,prev;
        Node(T data){
            this.data=data;
        }
        Node(T data ,Node<T> next ,Node<T> prev){
            this.data=data;
            this.next=next;
            this.prev=prev;
        }
        public String toString(){
            return " "+data;
        }
    }
    public void addAtFirst(T data){
        Node<T> newNode= new Node<>(data);
        if(head==null){
            head=tail=newNode;
        }else {
            Node<T> tmp =head;
            newNode.next=tmp;
            tmp.prev=newNode;
            head=newNode;
        }
    }
    public void printAll(){
        Objects.requireNonNull(head);
        Node<T> tmp =head;
        while (tmp!=null){
            System.out.print(tmp);
            tmp=tmp.next;
        }
        System.out.println();
    }

    public void printAllBackDir(){
        Objects.requireNonNull(tail);
        Node<T> tmp =tail;
        while (tmp!=null){
            System.out.print(tmp);
            tmp=tmp.prev;
        }
        System.out.println();
    }
    public void addAtLast(T data){
        Node<T> newNode= new Node<>(data);
        if(tail==null){
            head=tail=newNode;
        }else {
            Node<T> tmp =tail;
            tmp.next=newNode;
            newNode.prev=tmp;
            tail=newNode;
        }
    }

    public  void addKthPosition(T data ,int k){
        Objects.requireNonNull(head);
        Node<T> tmp = head;
        int count=0;
        boolean flag =false;
        while (tmp!=null){
            if(count==k){
                flag=true;
                break;
            }
            count++;
            tmp=tmp.next;
        }
        if(flag){
            addNode(data ,tmp);
        }
    }

    public void addNode(T data ,Node<T> current){
        Node<T> newNode = new Node<>(data);
        if(current.next==null){
            addAtLast(data);
        }else if(current.prev==null){
            addAtFirst(data);
        }else{
            Node<T> ptr =current;
            Node<T> ptrNext= current.next;
            ptr.next=newNode;
            newNode.prev=ptr;
            newNode.next=ptrNext;
            ptrNext.prev=newNode;
        }
    }

    public void removeDuplicate() {
        Node<T> tmp = head;
        while (tmp != null) {
            Node<T> ptr = tmp.next;
            while (ptr != null) {
                if (tmp.data.compareTo(ptr.data) == 0) {
                    deleteNode(ptr);
                }
                ptr = ptr.next;
            }
            tmp = tmp.next;
        }
    }

    private void deleteNode(Node<T> node) {
        if (node.next == null) {
            tail = node;
        } else if (node.prev == null) {
            head = node;
        } else {
            Node<T> prev =node.prev;
            Node<T> next =node.next;
            prev.next=next;
            next.prev=prev;
        }
    }




}
class Testing{
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.addAtFirst(10);
        dll.addAtFirst(20);
        dll.addAtFirst(30);
        dll.addAtFirst(40);
        dll.addAtFirst(50);
        dll.addAtFirst(60);
        dll.addAtFirst(70);
        dll.addAtFirst(80);
        dll.printAll();
        dll.printAllBackDir();
        dll.addAtLast(50);
       dll.addAtLast(70);
       dll.addAtLast(80);
     ///   dll.printAll();
     ///   dll.printAllBackDir();
      //  dll.addKthPosition(100,0);
        dll.printAll();
        dll.printAllBackDir();
       // dll.addKthPosition(29,13);
        dll.removeDuplicate();
        dll.printAll();
        dll.printAllBackDir();
       // dll.addKthPosition(299,13);
        dll.removeDuplicate();
        dll.printAll();
        dll.printAllBackDir();

    }
}
