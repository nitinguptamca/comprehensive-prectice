package com.comprehensive.practice.InterviewQA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GeneralTree1<T extends Comparable<T>> {

    public Node<T> root;

    public void add(T data, int position) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            add(root, position);
        }
    }

    private void add(Node<T> node, int position) {
        node.childs.get(position).addChild(node);
    }

    public int getMaxHeight(Node<T> root) {
        if(root==null) return 0;

        int count=0;
        Stack<Node<T>> stack =new Stack<>();
        stack.push(root);
        if(!stack.isEmpty()){
            Node<T> current = stack.pop();
            count++;
            List<Node<T>> childs = current.getChilds();
            for (int i = 0; i < childs.size(); i++) {
                if(childs.get(i)!=null){

                }
            }
        }
        return count;
    }

    static class Node<T extends Comparable<T>> {
        T key;
        List<Node<T>> childs;
        boolean haveChild=false;

        public boolean isHaveChild() {
            return haveChild;
        }

        public void setHaveChild(boolean haveChild) {
            this.haveChild = haveChild;
        }

        public Node(T key) {
            this.key = key;
            childs = new ArrayList<>();
        }

        public void addChild(Node<T> newNode) {
            this.childs.add(newNode);
        }


        public List<Node<T>> getChilds() {
            return childs;
        }

        @Override
        public String toString() {
            return "childs " + Arrays.toString(childs.toArray());
        }
    }


}

class GenericTreeDemo {
    public static void main(String[] args) {
        GeneralTree1<Integer> gt = new GeneralTree1<>();
        GeneralTree1.Node<Integer> root = new GeneralTree1.Node<>(10);///level1
        root.childs.add(new GeneralTree1.Node<>(1));
        root.childs.add(new GeneralTree1.Node<>(2));
        root.childs.add(new GeneralTree1.Node<>(3)); //level 2
        root.childs.get(0).addChild(new GeneralTree1.Node<>(10));
        root.childs.get(0).setHaveChild(true);
        root.childs.get(0).addChild(new GeneralTree1.Node<>(20));
        root.childs.get(0).addChild(new GeneralTree1.Node<>(30));
        root.childs.get(1).addChild(new GeneralTree1.Node<>(40));
        root.childs.get(2).addChild(new GeneralTree1.Node<>(50));
        root.childs.get(2).addChild(new GeneralTree1.Node<>(60));///leve 3
        root.childs.get(2).getChilds().get(0).addChild(new GeneralTree1.Node<>(50));

        System.out.println("get max Height "+gt.getMaxHeight(root));


    }



}
