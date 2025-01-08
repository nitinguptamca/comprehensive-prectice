package com.comprehensive.practice.oops;

interface ISuper{
    public void display();
}
public class SuperClass implements ISuper{
    public void displaySuper(){
        System.out.println("super display");
    }

    @Override
    public void display() {
        System.out.println("I super");
    }
}
class Subclass extends SuperClass{
    public void displaySub(){
        System.out.println("sub class  display");
    }
}

class Testing {
    public static void main(String[] args) {
        Subclass subclass= new Subclass();
        subclass.displaySuper();
        subclass.displaySub();
        subclass.display();
        ISuper iSuper= new Subclass();
        iSuper.display();
        //iSuper.displaySuper();
       // iSuper.displaySub();
    }
}
