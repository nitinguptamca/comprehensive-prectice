package com.comprehensive.practice.datastructure.list.sll;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class SingleLinkedList<E extends Comparable<E>> {
    Node<E> head, tail;

    public void addAtPosition(E element, int position) {
        Objects.requireNonNull(head);
        Node<E> tmp =head;
        int count =1;
        boolean flag =false;
        while (tmp!=null){
            if(count==position-1) {
                flag=true;
                break;
            }
            count++;
            tmp=tmp.next;
        }
        if (flag) {
            Node<E> ptr = tmp;
            Node<E> ptrNext = ptr.next;
            Node<E> newNode = new Node<>(element);
            ptr.next=newNode;
            newNode.next=ptrNext;
        }else throw new IndexOutOfBoundsException("exceed Number of elements");
    }

    public void kThAddFromLast(E element, int k) {
        Objects.requireNonNull(head);
        Node<E> tmp = head;
        Node<E> s =head;
        int count =1;
        boolean flag=false;
        while (tmp!=null){
            if(count<=k) {
                count++;
                tmp = tmp.next;
            }else {
                s=s.next;
                tmp=tmp.next;
                flag=true;
            }
        }
        if(flag==true) {
            Node<E> current = s;
            Node<E> currentToNext = s.next;
            Node<E> newNode = new Node<>(element);
            current.next = newNode;
            newNode.next = currentToNext;
        }else  throw new IndexOutOfBoundsException("exceed limit");
    }

    public void addAfterThisNode(Node<E> addAfter, E element) {
        Node<E> newNode = new Node<>(element);
        Objects.requireNonNull(head);
        Node<E> current = head;
        boolean flag =false;
        while (current!=null){
            if(current.element.compareTo(addAfter.element)==0){
                flag=true;
                break;
            }
            current=current.next;
        }
        if(flag){
           Node<E> ptr =current;
           Node<E> ptrTpNext = ptr.next;
           ptr.next=newNode;
           newNode.next=ptrTpNext;
        }else throw  new IndexOutOfBoundsException("exceed limit");
    }

    public void deleteAtFirst() {
        Objects.requireNonNull(head);
        Node<E> tmp =head.next;
        head=tmp;
    }

    public void deleteLast() {
        Objects.requireNonNull(head);
        Node<E> tmp =head;
        while (tmp.next!=null&& tmp.next.next!=null ) tmp=tmp.next;
        tmp.next=tmp.next.next;
    }

    public void deleteMiddle() {
        Objects.requireNonNull(head);
        Node<E> middle= getBeforeMiddle(head);
        middle.next=middle.next.next;
    }

    private Node<E> getBeforeMiddle(Node<E> head) {
        Objects.requireNonNull(head);
        Node<E> slowPointer = head;
        Node<E> fastPointer= head.next;
        while (fastPointer!=null){
            fastPointer=fastPointer.next;
            if(fastPointer!=null){
                fastPointer=fastPointer.next;
                slowPointer=slowPointer.next;
            }
        }
        return slowPointer;
    }

    public void removeDuplicate() {
        Node<E> tmp =head;
        while (tmp!=null){
            Node<E> ptr =tmp.next;
            while (ptr!=null && ptr.next!=null){
                if (tmp.element.compareTo(ptr.next.element) == 0) {
                    ptr.next = ptr.next.next;
                } else if (ptr.element.compareTo(ptr.next.element) == 0) {
                    ptr.next = ptr.next.next;
                }
                ptr=ptr.next;
            }
            tmp=tmp.next;
        }
    }

    public void reverseOrder() {
        Node<E> current =head;
        Node<E> previous=null ,next =null;
        while (current!=null){
        next =current.next;
        current.next=previous;
        previous=current;
        current=next;
        }
        head=previous;
    }

    public void mergeSort() {
        if (head == null) return;
        head = mergeSort(head);
    }

    private Node mergeSort(Node<E> h) {
        // Base case : if head is null
        if (h == null || h.next == null) {
            return h;
        }
        // get the middle of the list
        Node<E> middle = getMiddle(h);
        Node<E> nextofmiddle = middle.next;
        // set the next of middle node to null
        middle.next = null;
        // Apply mergeSort on left list
        Node<E> left = mergeSort(h);
        // Apply mergeSort on right list
        Node<E> right = mergeSort(nextofmiddle);
        // Merge the left and right lists
        Node<E> sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    protected Node<E> sortedMerge(Node<E> a, Node<E> b) {
        Node<E> result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.element.compareTo(b.element) > 0) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

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

    public void addAtLast(E element){
        Node<E> newNode= new Node<>(element);
        if(head==null){
            head=tail=null;
        }else {
            Node<E> current = tail;
            current.next=newNode;
            tail=newNode;
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

    public void addAtMiddle(E element){
        Objects.requireNonNull(head);
        Node<E> newNode= new Node<>(element);
        Node<E> middle =getMiddle(head);
        Node<E> nextToMiddle = middle.next;
        middle.next= newNode;
        newNode.next=nextToMiddle;
    }



    private Node<E> getMiddle(Node<E> head) {
        Objects.requireNonNull(head);
        Node<E> slowPointer = head;
        Node<E> fastPointer= head;
        while (fastPointer!=null){
            fastPointer=fastPointer.next;
            if(fastPointer!=null){
                fastPointer=fastPointer.next;
                slowPointer=slowPointer.next;
            }
        }
        return slowPointer;
    }

    public boolean detectCycleInLinkedList(Node<E> node) {
        if (head == null) {
            return false;
        } else {
            HashSet<Node> visited = new HashSet<Node>();
            boolean flag = false;
            Node tmp = head;
            while (tmp != null) {
                if (visited.contains(tmp))
                    return true;
                visited.add(tmp);
                tmp = tmp.next;
            }
            return false;
        }
    }

    public boolean detectCycleInLinkedList_app2(Node<E> node) {
        if (head == null) {
            return false;
        } else {
            Map<Node, Boolean> visited = new HashMap<>();
            boolean flag = false;
            Node tmp = head;
            while (tmp != null) {
                if (visited.containsKey(tmp))
                    return true;
                visited.put(tmp, true);
                tmp = tmp.next;
            }
            return false;
        }
    }

//    public boolean deleteNode(Node<E> deleteNode) {
//        Node<E>  ptr = head;
//        Node<E> prev = head;
//        int count=0;
//        while (ptr != null) {
//            if(ptr.element.compareTo(deleteNode.element)==0){
//                if(count==0) removeAtFirst();
//                else if(count==size) removeAtLast();
//                else{
//                    Node<T>  beforeCurrent =prev;
//                    beforeCurrent.next=beforeCurrent.next.next;
//                    return true;
//                }
//                return true;
//            }
//            prev=ptr;
//            ptr=ptr.next;
//            count++;
//        }
//        return false;
//    }


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
       /* sll.addAtFirst(108);
        sll.addAtLast(109);
        sll.addAtLast(10);
        sll.addAtLast(20);
        sll.addAtLast(100);

        sll.addAtLast(30);
        sll.addAtLast(40);
        sll.addAtLast(50);
        sll.addAtLast(60);
        sll.addAtLast(170);
        sll.addAtLast(108);
        sll.addAtLast(109);*/
      //  sll.addAtPosition(100,10);
       // sll.addAtPosition(90,90);
        //sll.kThAddFromLast(77,7);
        //sll.printAll();
      //  sll.kThAddFromLast(77,77);
     //   sll.printAll();
       // sll.addAfterThisNode(new SingleLinkedList.Node<>(100) , 200);
        //sll.printAll();
        //sll.addAfterThisNode(new SingleLinkedList.Node<>(1000) , 200);
        sll.printAll();
       // sll.deleteAtFirst();
      //  sll.deleteLast();
       // sll.deleteMiddle();
       // sll.printAll();
      //  sll.deleteAtFirst();
       // sll.deleteLast();
        //sll.deleteMiddle();
        //sll.removeDuplicate();
        //sll.printAll();
        //sll.removeDuplicate();
        //sll.printAll();
        //sll.removeDuplicate();
       // sll.reverseOrder();
      //  sll.mergeSort();
       // sll.printAll();
       // sll.deleteAtFirst();
       /* sll.delete(170);
        sll.printAll();
        sll.delete(109);
        sll.printAll();
        sll.delete(10);
        sll.printAll();
        sll.delete(30);
        sll.printAll();*/

    }
}