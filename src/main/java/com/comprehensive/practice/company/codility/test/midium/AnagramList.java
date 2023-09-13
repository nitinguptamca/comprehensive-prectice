package com.comprehensive.practice.company.codility.test.midium;

import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AnagramList {
    public static void main(String[] args) {
        String[] strArr = {"cat", "cta", "act", "atc", "tac", "tca"};
        boolean count = Arrays.stream(strArr)
                .map(String::toCharArray)
                .map(arr -> {
                    Arrays.sort(arr);
                    return arr;
                })
                .map(String::valueOf)
                .distinct()
                .count() == 1;
        System.out.println(count);
        boolean kkkk = Stream.of(strArr).map(String::toCharArray).peek(Arrays::sort)
                .distinct().count() == 1;

        boolean solution1 = Stream.of(strArr) // Stream<String>
                .map(String::toCharArray) // Stream<char[]>
                .peek(Arrays::sort) // sort
                .map(String::valueOf) // Stream<String>
                .distinct() //distinct
                .count() == 1;

        boolean anagrams = Stream.of(strArr)
                .map(String::chars)
                .map(IntStream::sorted)
                .map(IntStream::toArray)
                .map(Arrays::toString)
                .distinct().count() == 1;

        boolean sss = Stream.of(strArr)
                .map(s -> IntBuffer.wrap(s.chars().sorted().toArray()))
                .distinct().count() == 1;


        boolean adafas=Arrays.stream(strArr)
                .map(String::chars)
                .map(IntStream::sorted)
                .map(IntStream::toArray)
                .map(Arrays::toString)
                .distinct().count()==1;






    }
}
