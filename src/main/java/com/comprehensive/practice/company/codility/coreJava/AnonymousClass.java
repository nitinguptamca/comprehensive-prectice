package com.comprehensive.practice.company.codility.coreJava;

/**
 * A local inner class without name is known as anonymous inner class. An anonymous class is defined and instantiated in a single statement. Anonymous inner class always extend a class or implement an interface. Since an anonymous class has no name, it is not possible to define a constructor for an anonymous class
 */
public class AnonymousClass {
    int count = 1;
    Runnable action = new Runnable() {
        @Override
        public void run() {
            System.out.println("Runnable with captured variables: " + count);
        }
    };

    private int testing=123;

    abstract class AbstractClass {
        abstract void doSomething();
    }

    public static void main(String[] args) {
        AnonymousClass anonymousClass = new AnonymousClass();
        AbstractClass testingew= anonymousClass.new AbstractClass() {
            @Override
            void doSomething() {
                System.out.println("example of anonymous class");
            }
        };

        testingew.doSomething();

    }


}
