package com.comprehensive.practice.company.codility.test.easy;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * How to convert Stream of Characters into a String in Java 8
 *
 */
public class ConvertStreamOfCharToString {
    public static void main(String[] args) {
        Stream<Character> testStream = Stream.of('a', 'b', 'c');

        String result = testStream.collect(Collector.of(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append,
                StringBuilder::toString));

        Stream<Character> st = Stream.of('C','h','t');
        String result1 = st.map(c->c.toString()).collect(Collectors.joining());
        System.out.println(result1);  //Cht
    }

    public static String reverseIt(String source) {
        int i, len = source.length();
        StringBuilder dest = new StringBuilder(len);

        for (i = (len - 1); i >= 0; i--){
            dest.append(source.charAt(i));
        }

        return dest.toString();
    }
}
