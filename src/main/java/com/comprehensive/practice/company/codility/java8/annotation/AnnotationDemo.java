package com.comprehensive.practice.company.codility.java8.annotation;


import java.lang.annotation.*;

// Using target annotation to annotate a type
@Target(ElementType.TYPE_USE)
// Declaring a simple type annotation
@interface TypeAnnoDemo {
}

// Create container annotation
@Retention(RetentionPolicy.RUNTIME)
@interface MyRepeatedAnnos
{
    Words[] value();
}

// Make Words annotation repeatable
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatedAnnos.class)
@interface Words
{
    String word() default "Hello";
    int value() default 0;
}

public interface AnnotationDemo {
}

class TypeAnnotationJava {

    // Main driver method
    public static void main(String[] args) {

        // Annotating the type of a string
        @TypeAnnoDemo String string = "I am annotated with a type annotation";
        @MyRepeatedAnnos({}) String[] aaa = new String[8];

        System.out.println(string);
        abc();
    }

    // Annotating return type of a function
    static @TypeAnnoDemo int abc() {

        System.out.println("This function's  return type is annotated");

        return 0;
    }
}
