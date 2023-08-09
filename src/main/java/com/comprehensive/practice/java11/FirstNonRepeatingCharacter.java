package com.comprehensive.practice.java11;

import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.concurrent.Semaphore;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String  str= "jksfhkqshfqwuaieqfqiw";
        Consumer<Character> callback = a -> System.out.println(a);
        Optional<Character> charaaaa = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1L)
                .map(entry -> entry.getKey()).findFirst().map(c -> {
                    callback.accept(c);
                    return c;
                });

    }
}
