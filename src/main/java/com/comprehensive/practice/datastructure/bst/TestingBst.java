package com.comprehensive.practice.datastructure.bst;

public class TestingBst {
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

        bst.printInorder(bst.getRoot());
        System.out.println("\n height_of_tree"+bst.height_of_tree(bst.getRoot()));
        //bst.levelOrderTraversal(bst.getRoot());
       // System.out.println("\n count ::"+ bst.countElement(bst.getRoot()));
       // System.out.println("\n smallest ::"+ bst.findSmallest(bst.getRoot()));
        //System.out.println("\n k smallest "+bst.KSmallestUsingMorris(bst.getRoot() ,4));
    }
}
