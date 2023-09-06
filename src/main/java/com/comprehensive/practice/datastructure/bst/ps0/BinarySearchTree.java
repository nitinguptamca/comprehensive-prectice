package com.comprehensive.practice.datastructure.bst.ps0;

import lombok.Getter;

import java.util.LinkedList;
import java.util.Queue;

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

    @Getter
    private Node<T> root;
    int count = 0;

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

    //left-right-root
    public void postOrderTraverse(Node<T> node) {
        if (node.leftChild != null) preOrderTraverse(node.leftChild);
        if (node.rightChild != null) preOrderTraverse(node.rightChild);
        System.out.print(node);
    }

    //root-left-right
    public void preOrderTraverse(Node<T> node) {
        System.out.print(node);
        if (node.leftChild != null) preOrderTraverse(node.leftChild);
        if (node.rightChild != null) preOrderTraverse(node.rightChild);
    }

    public int countElement(Node<T> node) {
        if (node == null) return 0;
        return 1 + countElement(node.leftChild) + countElement(node.rightChild);
    }

    public int  countNode(Node<T> node) {
        if(node==null) return 0;
        else{
            int l =1;
            l +=countNode(node.leftChild);
            l+=countNode(node.rightChild);
            return l;
        }
    }

    public void printLeafNode(Node<T> node) {
        if(node == null) return;
        if(node.leftChild==null && node.rightChild==null)
            System.out.print(node);
        if(node.leftChild!=null) printLeafNode(node.leftChild);
        if(node.rightChild!=null) printLeafNode(node.rightChild);
    }

    private boolean searchData(T data, Node<T> node) {
        if (node == null) return false;
        if (node.data.compareTo(data) > 0) {
            return searchData(data, node.leftChild);
        } else if (node.data.compareTo(data) < 0) {
            return searchData(data, node.rightChild);
        } else if (node.data.compareTo(data) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Node<T> mirror(Node<T> node) {
        if(node ==null) return node;
        Node<T> left = mirror(node.leftChild);
        Node<T> right = mirror(node.rightChild);
        node.leftChild=right;
        node.rightChild=left;
        return node;
    }

    public boolean isFordableTree(Node<T> node) {
        if(node==null) return true;
        return check(node.leftChild ,node.rightChild);
    }

    private boolean check(Node<T> left ,Node<T> right) {
        if(left==null && right==null) return true;
        else if(left!=null && right==null) return false;
        else if(left==null && right!=null) return false;
        else{
            return check(left.leftChild ,right.rightChild) &&
                    check(left.rightChild ,right.leftChild);
        }
    }

    public Node<T> getMax(Node<T> node) {

        return node.rightChild==null ?node:getMax(node.rightChild);
    }

    public Node<T> getMin(Node<T> node) {
        return node.leftChild==null ?
                node: getMin(node.leftChild);
    }
    public boolean  isStructureSame(Node<Integer> a, Node<Integer> b) {
        if(a==null && b==null) return true;
        else if (a != null && b != null
                && isStructureSame(a.leftChild, b.leftChild)
                && isStructureSame(a.rightChild, b.rightChild)) return true;
        else return false;
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

    public Node<T> findSmallest(Node<T> node){
        while (node.leftChild!=null){
            node=node.leftChild;
        }
        return node;
    }

    public Node<T> findMax(Node<T> node){
        while (node.rightChild!=null){
            node=node.rightChild;
        }
        return node;
    }


   public Node<T> kthSmallestNodePr23(Node<T> node ,int k){
        if(node==null) return null;
        int count =0;
        Node<T> current = node;
        while(current!=null){
            if(current.leftChild==null){
             count++;
             if(count==k) return current;
             current=current.rightChild;
            }else{
                Node<T> left = current.leftChild;
                while (left.rightChild!=null | left.rightChild!=current) left=left.rightChild;
                if(left.rightChild==null){
                    left.rightChild=current;
                    current=current.leftChild;
                }else {
                    left.rightChild=null;
                    count++;
                    if(count==k) return current;
                    current=current.rightChild;
                }
            }
        }
        return current;
   }

   int leftcount=0;
    public Node<T> kthSmallesdsfsPr4stNode(Node<T> node,int k){
        if(node==null) return null;
        Node<T> left = kthSmallesdsfsPr4stNode(node.leftChild ,k);
        if(left!=null) left=left;
        leftcount++;
        if(leftcount==k) return node;
        return kthSmallesdsfsPr4stNode(node.rightChild ,k);
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

    public Node<T> ksmallestNode(Node<T> node ,int k){
        if(node==null) return null;
        int count=0;
        Node<T> current =node;
        while (current!=null){
            if(current.leftChild==null){
                count++;
                if(count==k) return current;
                current=current.rightChild;
            }else {
                Node<T> pre = current.leftChild;
                while (pre.rightChild!=null && pre.rightChild!=current)
                    pre=pre.rightChild;
                if (pre.rightChild==null){
                    pre.rightChild = current;
                    current = current.leftChild;
                }else{
                    pre.rightChild=null;
                    count++;
                    if(count==k) return current;
                    current=current.rightChild;
                }
            }
        }
        return current;
    }

    public void delete(T data) {
        if (root == null) return;
        delete(data, root);
    }

    public void delete(T deleteData, Node<T> node) {
        if (node == null) return;
        else if (node.data.compareTo(deleteData) > 0) {
            delete(deleteData, node.leftChild);
        } else if (node.data.compareTo(deleteData) < 0) {
            delete(deleteData, node.rightChild);
        } else {
            System.out.println("data is present in the BST");
            //Node<T> parent= node.parentNode;
            if (node.leftChild == null && node.rightChild == null) {
                System.out.println("case 1 when left child and right Child both are null");
                Node<T> parent = node.parentNode;
                if (parent != null && parent.leftChild == node) {
                    parent.leftChild = null;
                } else if (parent != null && parent.rightChild == node) {
                    parent.rightChild = null;
                } else if (parent == null) {
                    root = null;
                } else {
                }
                //Node must be gc
                node = null;
            } else if (node.leftChild != null && node.rightChild == null) {
                System.out.println("case 2 when left child not null and right Child both are null");
                Node<T> parent = node.parentNode;
                if (parent != null && parent.leftChild == node) {
                    parent.leftChild = node.leftChild;
                } else if (parent != null && parent.rightChild == node) {
                    parent.rightChild = node.leftChild;
                } else if (parent == null) {
                    root =parent.leftChild;
                } else {
                }
                node.leftChild.parentNode=parent;
                //node must be GC
                node=null;
            } else if (node.leftChild == null && node.rightChild != null) {
                System.out.println("case 2 when left child  null and right Child both are not null");
                Node<T> parent = node.parentNode;
                if (parent != null && parent.leftChild == node) {
                    parent.leftChild = node.rightChild;
                } else if (parent != null && parent.rightChild == node) {
                    parent.rightChild = node.rightChild;
                } else if (parent == null) {
                    root =parent.rightChild;
                } else {
                }
                node.rightChild.parentNode=parent;
                //node must be GC
                node=null;

            } else {
                System.out.println("case 4 when left child and right Child both are not null");
                Node<T> predecessor = getPredecessor(node.rightChild);
                T temp = predecessor.data;
                predecessor.data = node.data;
                node.data = temp;
                delete(deleteData, predecessor);

            }
        }
    }

    private Node<T> getPredecessor(Node<T> node) {
        if(node.leftChild!=null) return getPredecessor(node.leftChild);
        return node;
    }

    public void levelOrderTraversal(Node<T> node) {
        if (node == null)
            return;
        Queue<Node> queues = new LinkedList<>();
        queues.add(node);
        while (!queues.isEmpty()) {
            Node node1 = queues.remove();
            if (node1.leftChild != null) {
                queues.add(node1.leftChild);
            }
            if (node1.rightChild != null) {
                queues.add(node1.rightChild);
            }
        }
    }


    int height_of_tree(Node<T> node){
        if(node==null) return 0;
        return Math.max(height_of_tree(node.leftChild), height_of_tree(node.rightChild)) + 1;
    }

}
