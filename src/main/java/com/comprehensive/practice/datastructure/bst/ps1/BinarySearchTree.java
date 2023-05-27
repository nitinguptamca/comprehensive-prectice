package com.comprehensive.practice.datastructure.bst.ps1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public T kLargestElement(int k) {
        if (root == null) return null;
        int count = 0;
        Node<T> tmp = root;
        while (tmp != null) {
            if (tmp.rightChild == null) {
                count++;
                if (count == k) return tmp.data;
                tmp = tmp.leftChild;
            } else {
                Node<T> ptr = tmp.rightChild;
                while (ptr.leftChild != null && ptr.leftChild != tmp)
                    ptr = ptr.leftChild;
                if (ptr.leftChild == null) {
                    ptr.leftChild = tmp;
                    tmp = tmp.rightChild;
                } else {
                    ptr.leftChild = null;
                    count++;
                    if (count == k) return tmp.data;
                    tmp = tmp.leftChild;
                }
            }
        }
        return tmp.data;
    }

    public int countElement(Node<T> node) {
        if (node == null) return 0;
        return 1 + countElement(node.leftChild) + countElement(node.rightChild);
    }


    public int heightOfTree(Node<T> node) {
        if (node == null) return 0;
        return Math.max(heightOfTree(node.leftChild), heightOfTree(node.rightChild)) + 1;
    }

    public T findMax(Node<T> node) {
        if (node == null) return null;
        while (node.rightChild != null) node = node.rightChild;
        return node.data;
    }

    public T findMin(Node<T> node) {
        if (node == null) return null;
        while (node.leftChild != null) node = node.leftChild;
        return node.data;
    }

    public void inorderTraverseWithoutRecursive(Node<T> node) {
        if (node == null) return;
        Stack<Node<T>> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.leftChild;
            } else {
                Node<T> ptr = stack.pop();
                System.out.print( node);
                node = ptr.rightChild;
            }
        }
    }

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
                node.leftChild = new Node(data, node);
            } else {
                addElement(data, node.leftChild);
            }
        } else {
            if (node.rightChild == null) {
                node.rightChild = new Node<>(data, node);
            } else {
                addElement(data, node.rightChild);
            }
        }
    }

    public void printInorderTraversal(Node<T> node) {
        if (node.leftChild != null) printInorderTraversal(node.leftChild);
        System.out.print(node);
        if (node.rightChild != null) printInorderTraversal(node.rightChild);
    }

    public T kSmallestElement(int k) {
        if (root == null) return null;
        int count = 0;
        Node<T> tmp = root;
        while (tmp != null) {
            if (tmp.leftChild == null) {
                count++;
                if (count == k) return tmp.data;
                tmp = tmp.rightChild;
            } else {
                Node<T> ptr = tmp.leftChild;
                while (ptr.rightChild != null && ptr.rightChild != tmp)
                    ptr = ptr.rightChild;
                if (ptr.rightChild == null) {
                    ptr.rightChild = tmp;
                    tmp = tmp.leftChild;
                } else {
                    ptr.rightChild = null;
                    count++;
                    if (count == k) return tmp.data;
                    tmp = tmp.rightChild;
                }
            }
        }
        return tmp.data;
    }

    public void levelOrderTraversal(Node<T> node) {
        if (node == null)
            return;
        Queue<Node> queues = new LinkedList<>();
        queues.add(node);
        while (!queues.isEmpty()) {
            Node node1 = queues.remove();
            System.out.print(node1);
            if (node1.leftChild != null) {
                queues.add(node1.leftChild);
            }
            if (node1.rightChild != null) {
                queues.add(node1.rightChild);
            }
        }
    }

    public void printLeafNode(Node<T> node) {
        if (node == null) return;
        if (node.leftChild == null && node.rightChild == null) {
            System.out.print(node);
        }
        if (node.leftChild != null) printLeafNode(node.leftChild);
        if (node.rightChild != null) printLeafNode(node.rightChild);
    }

    public  void printLeaf(Node<T> node) {
        if (node == null) return;
        Stack<Node<T>> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node<T> ptr = stack.pop();
            if (ptr.leftChild != null) {
                stack.add(ptr.leftChild);
            }
            if (ptr.rightChild != null) {
                stack.add(ptr.rightChild);
            }
            if (ptr.leftChild==null && ptr.rightChild==null) {
                System.out.printf("%s ", ptr.data);
            }
        }
    }


    public  void printLeaf12(Node<T> node) {
        if (node == null) return;
        Queue<Node<T>> stack = new LinkedList<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            Node<T> ptr = stack.remove();
            if (ptr.leftChild != null) {
                stack.add(ptr.leftChild);
            }
            if (ptr.rightChild != null) {
                stack.add(ptr.rightChild);
            }
            if (ptr.leftChild==null && ptr.rightChild==null) {
                System.out.printf("%s ", ptr.data);
            }
        }
    }



}


class Testing {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.addElement(25);
        bst.addElement(20);
        bst.addElement(15);
        bst.addElement(10);
        bst.addElement(5);
        bst.addElement(30);
        bst.addElement(35);
        bst.addElement(40);
        bst.addElement(24);
        bst.addElement(22);
        bst.addElement(23);
        bst.addElement(33);
        bst.addElement(31);
        bst.addElement(32);
        bst.addElement(43);
        bst.addElement(38);
        bst.addElement(34);
        bst.addElement(45);
        bst.addElement(8);
        bst.addElement(29);
        bst.addElement(2);
        bst.addElement(12);
        bst.addElement(17);

        bst.printInorderTraversal(bst.getRoot());
        System.out.println();
        bst.inorderTraverseWithoutRecursive(bst.getRoot());
        //bst.printLeaf12(bst.getRoot());
        //System.out.println();
        //bst.printLeaf(bst.getRoot());
        // System.out.println(bst.countElement(bst.getRoot()));
        /// System.out.println(bst.heightOfTree(bst.getRoot()));
        //// System.out.println(bst.findMin(bst.getRoot()));
        /// System.out.println(bst.findMax(bst.getRoot()));
        ///  bst.levelOrderTraversal(bst.getRoot());
        //System.out.println();
        // bst.printLeafNode(bst.getRoot());
        //  bst.printLeafNode12(bst.getRoot());
        //System.out.println(bst.kSmallestElement(4));
        //System.out.println(bst.kLargestElement(4));

    }
}
