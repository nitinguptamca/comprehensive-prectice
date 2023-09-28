package com.comprehensive.practice;

import java.util.Stack;

public class GeneralTree<T extends Comparable<T>> {

    Node<T> root;

    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data, null);
        } else {
            insert(data, root);
        }
    }

    private void insert(T data, Node<T> node) {
        if (node.data.compareTo(data) > 0) {
            if((Integer) data>5) {
                if (node.leftChild == null) {
                    node.leftChild = new Node<>(data, node);
                } else {
                    insert(data, node.leftChild);
                }
            }else{
                if (node.leftchild1 == null) {
                    node.leftchild1 = new Node<>(data, node);
                } else {
                    insert(data, node.leftchild1);
                }
            }
        } else {
            if((Integer) data>50){
                if (node.rightChild == null) {
                    node.rightChild = new Node<>(data, node);
                } else {
                    Node<T> rightChild = node.rightChild;
                    insert(data, rightChild);
                }
            }else{
                if (node.rightChild1 == null) {
                    node.rightChild1 = new Node<>(data, node);
                } else {
                    Node<T> rightChild1 = node.rightChild1;
                    insert(data, rightChild1);
                }
            }

        }
    }

    public int height() {
        return height(root);
    }

    public int height(Node<T> node) {
        if(node==null) return 0;
        Stack<Node<T>> stack = new Stack<>();
        stack.add(node);
        int count =1;
        int left1 =0;int left =0;int right =0;int right1 =0;

        while (!stack.isEmpty()){
           Node<T> node1 =stack.pop();

                if (node1.leftchild1 != null){ stack.push(node1.leftchild1);
                left1++;
            }

                if (node1.leftChild != null){ stack.push(node1.leftChild);
                left++;
            }

                if (node1.rightChild != null){ stack.push(node1.rightChild);
                right++;
            }

                if (node1.rightChild1 != null){ stack.push(node1.rightChild1);
                right1++;
            }
        }
        int leftMax= Math.max(left ,left1);
        int rigtMax =Math.max(right1 ,right);
        count =count+ Math.max(leftMax ,rigtMax);
        return count;
    }

    static class Node<T extends Comparable<T>> {
        T data;
        Node<T> leftChild, rightChild, parentNode, leftchild1 ,rightChild1;

        public Node(T data, Node<T> parentNode) {
            this.data = data;
            this.parentNode = parentNode;
        }

        @Override
        public String toString() {
            return " " + data;
        }
    }
}

class Test {
    public static void main(String[] args) {
        GeneralTree<Integer> bst = new GeneralTree<>();
        bst.insert(10);
        bst.insert(9);
        bst.insert(11);
        bst.insert(13);
        bst.insert(7);
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(51);
        bst.insert(52);


        System.out.println("height " + bst.height());
    }
}