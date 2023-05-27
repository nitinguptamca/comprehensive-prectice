package com.comprehensive.practice.datastructure.list.sll;

public class SingleLinkedList<E extends Comparable<E>> {
    Node<E> head, tail;

    static class Node<E extends Comparable<E>> {
        E element;
        Node<E> next;

        Node(E element) {
            this.element = element;
        }

        public String toString() {
            return " " + element;
        }
    }

    public void addAtFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            Node<E> current = head;
            newNode.next = current;
            head = newNode;
        }
    }

    public void printAll() {
        Node<E> tmp = head;
        while (tmp != null) {
            System.out.print(tmp);
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void delete1(E element) {
        Node<E> tmp =head;
        if(head.element.compareTo(element)==0){
            Node<E> whenFoundFirstNode = head.next;
            head=whenFoundFirstNode;
        } else {
            while (tmp != null) {
                Node<E> ptr = tmp.next;
                while(ptr!=null){
                    if(ptr.element.compareTo(element)==0){
                        tmp.next=tmp.next.next;
                    }
                }
                tmp = tmp.next;
            }
        }
    }

    public void delete(E element) {
        if (head == null) return;
        Node<E> current = head;
        Node<E> previous = null;
        if (current.element.compareTo(element) == 0) {
            Node<E> tmp =current.next;
            head=tmp;
        } else
            while (current != null) {
                Node<E> next = current.next;
                if (current.element.compareTo(element) == 0) {
                    previous.next = next;
                    break;
                }
                previous = current;
                current = next;
            }
    }


}

class Testing {
    public static void main(String[] args) {
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.addAtFirst(10);
        sll.addAtFirst(20);
        sll.addAtFirst(30);
        sll.addAtFirst(40);
        sll.addAtFirst(50);
        sll.addAtFirst(60);
        sll.addAtFirst(170);
        sll.addAtFirst(108);
        sll.addAtFirst(109);
        sll.printAll();
        sll.delete(170);
        sll.printAll();
        sll.delete(109);
        sll.printAll();
        sll.delete(10);
        sll.printAll();
        sll.delete(30);
        sll.printAll();

    }
}