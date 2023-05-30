package com.comprehensive.practice.company.codility.test.midium;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author nitin
 * input "nitin" " abcdedcba"
 *
 */
public class ReverseString {
    public static void main1(String[] args) {
        String  input ="nitin";
        String reverseStr =input.chars()
        .mapToObj( e -> Character.valueOf((char)e))
                .reduce("", (s,c) -> c+s ,(s1 ,s2) ->s2+s1);
        System.out.println(input.equals(reverseStr));
        //-----------------------
        String reversed = input.chars()
                .collect(StringBuilder::new,
                        (b, c) -> b.insert(0, (char)c),
                        (b1, b2) -> b1.insert(0, b2))
                .toString();
        System.out.println(input.equals(reversed));

       String reversed1= Stream.of(input)
                .map(word->new StringBuilder(word).reverse())
                .collect(Collectors.joining(""));
        System.out.println(input.equals(reversed1));

        String reverse3 = input.chars()
                .collect(StringBuilder::new,
                        (sb, c) -> sb.append((char) c),
                        StringBuilder::append)
                .toString();
        System.out.println(reverse3.equals(input));

        char[] charArray = input.toCharArray();
        String reverse4 = IntStream.range(0, charArray.length)
                .mapToObj(i -> charArray[(charArray.length - 1) - i])
                .map(e -> e.toString())
                .collect(Collectors.joining());
        System.out.println(reverse4);

        String value = input
                .chars()
                .mapToObj(i -> (char) i)
                .map(String::valueOf)
                .map(word->new StringBuilder(word).reverse())
                .collect(Collectors.joining());
        System.out.println("cssss:: "+value);


        String s = "blast";
        IntStream.range(0, s.length()).           // create index [0 .. s.length - 1]
               // s.chars().
                boxed().                               // the next step requires them boxed
                sorted(Collections.reverseOrder()).    // indices in reverse order
                map(i -> String.valueOf(s.charAt(i))). // grab each index's character
                collect(Collectors.joining());         // join each single-character String into the final String

        String kk= s.chars().mapToObj( c -> Character.valueOf((char)c)).reduce("", (a,b) -> b+a ,(s1,s2) -> s2+s1);
        kk= s.chars().mapToObj( c -> (char)c).reduce("", (a,b) -> b+a ,(s1,s2) -> s2+s1);
        System.out.println(kk);

    }

    public static void main(String[] args) {
        char[] charArray = "Aniruddh".toCharArray();
        IntStream.range(0, charArray.length)
                .mapToObj(i -> charArray[(charArray.length - 1) - i])
                .forEach(System.out::print);
    }
}
