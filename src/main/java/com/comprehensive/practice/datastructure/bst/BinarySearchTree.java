package com.comprehensive.practice.datastructure.bst;

public class BinarySearchTree<T extends Comparable<T>> {
    private static final class Node<T extends Comparable<T>> {
        T data;
        Node<T> leftChild, rightChild, parentNode;

        Node(T data, Node<T> parentNode) {
            this.data = data;
            this.parentNode = parentNode;
        }

        @Override
        public String toString() {
            return " " + data;
        }
    }

    private Node<T> root;
    int count = 0;

    public Node<T> getRoot() {
        return root;
    }

    public void addElement(T data) {
        if (root == null) {
            root = new Node<>(data, null);
        } else {
            addElement(data, root);
        }
    }

    private void addElement(T data, Node<T> node) {
        if (node.data.compareTo(data) > 0) {
            if (node.leftChild == null) {
                node.leftChild = new Node<>(data, node);
            } else {
                addElement(data, node.leftChild);
            }
        } else {
            if (node.rightChild == null) {
                node.rightChild = new Node<>(data, node.rightChild);
            } else {
                addElement(data, node.rightChild);
            }
        }
    }

    //left root right
    //natural order
    public void printInorder(Node<T> node) {
        if (node == null) return;
        printInorder(node.leftChild);
        System.out.print(node);
        printInorder(node.rightChild);
    }

    public int countElement(Node<T> node) {
        if (node == null) return 0;
        return 1 + countElement(node.leftChild) + countElement((node.rightChild));
    }

    public Node<T> kthSmallest(Node<T> node, int k) {
        if (node == null) return null;
        Node<T> left = kthSmallest(node.leftChild, k);
        if (left != null) return left;
        count++;
        if (count == k)
            return node;
        return kthSmallest(node.rightChild, k);
    }



    public Node<T> KthSmallestNode(Node<T> node ,int k){
        if(node==null) return null;
        int count=0;
        Node<T> current =node;
        while(current!=null){

            if(current.leftChild==null){
                count++;
                if(count==k) return current;
                current=current.rightChild;
            }else {
                Node<T> pre = current.leftChild;
                while (pre.rightChild!=null && pre.rightChild !=current) pre=pre.rightChild;
                if(pre.rightChild==null){
                    pre.rightChild=current;
                    current=current.leftChild;
                }else{
                    pre.rightChild=null;
                    count++;
                    if (count == k)
                        return current;
                    current = current.rightChild;
                }
            }
       }
      return  current;
    }


    public T KSmallestUsingMorris(Node<T> root, int k) {
        int count = 0;
        T ksmall = null; // store the Kth smallest
        Node<T> curr = root; // to store the current node
        while (curr != null) {
            if (curr.leftChild == null) {
                count++;
                if (count == k)
                    ksmall = curr.data;
                curr = curr.rightChild;
            } else {
                Node pre = curr.leftChild;
                while (pre.rightChild != null && pre.rightChild != curr)
                    pre = pre.rightChild;
                // building links
                if (pre.rightChild == null) {
                    //link made to Inorder Successor
                    pre.rightChild = curr;
                    curr = curr.leftChild;
                } else {
                    pre.rightChild = null;
                    count++;
                    if (count == k)
                        ksmall = curr.data;
                    curr = curr.rightChild;
                }
            }
        }
        return ksmall;
    }
}
