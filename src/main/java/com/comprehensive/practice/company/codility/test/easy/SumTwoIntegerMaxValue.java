package com.comprehensive.practice.company.codility.test.easy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class SumTwoIntegerMaxValue {

    public static void main(String[] args) {
        String s1 = String.valueOf(Integer.MAX_VALUE);
        String s2 = String.valueOf(Integer.MAX_VALUE);
        SumTwoIntegerMaxValue sumTwoIntegerMaxValue = new SumTwoIntegerMaxValue();
        String s3 = sumTwoIntegerMaxValue.getResult(s1 ,s2);
        System.out.println(s3);
    }
    
    public String getResult(String s1 , String s2){
        int a = Integer.valueOf(s1);
        int b = Integer.valueOf(s2);
        int c = Integer.MAX_VALUE;
        return  ""+(a + b+ c);
    }

    public static void listFileTree1() {
        Path dir = Paths.get("");
        System.out.printf("%nThe file tree for %s%n", dir.toAbsolutePath());
        try (Stream<Path> fileTree = Files.walk(dir)) {
            fileTree.forEach(System.out::println);
        } catch (IOException e) {e.printStackTrace();}
    }
}
