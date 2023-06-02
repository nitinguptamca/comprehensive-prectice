package com.comprehensive.practice.company.codility.test.easy;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCountParticularFile {
    public static void main111(String[] args) throws IOException {
        WordCountParticularFile particularFile = new WordCountParticularFile();
        Path path = Paths.get("D:\\roomno13\\comprehensive-prectice\\src\\main\\java\\com\\comprehensive\\practice\\datastructure\\bst\\ps0\\BinarySearchTree.java");
        Map<String, Long> sssss = particularFile.wordCount(path);
        System.out.println(sssss);


    }

    public Map<String, Long> wordCount(Path path) throws IOException {
        Stream<String> lines = Files.lines(path);
        Stream<String[]> stringArray = lines
                .flatMap(e -> e.lines().map(k -> k.trim().split(" ")));
        List<String> vvv = stringArray.flatMap(Stream::of).collect(Collectors.toUnmodifiableList());
        Map<String, Long> value = vvv.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return value;
    }

    public static void main1(String[] args) {
        String str = "A queue is a simple data structure where the insertion and deletion of elements take place from the one end, whereas Deque is a hybrid data structure serving the purpose of both the stack and queue and insertion and deletion of elements can take place from both the ends according to the requirements of the user.";

        Arrays.stream(str.split(" ")).flatMap(Stream::of)
                .collect(Collectors.groupingBy(Function.identity() ,Collectors.counting()));
    }

    public static void main3(String[] args) throws IOException {
        Path path = Paths.get("D:\\roomno13\\comprehensive-prectice\\src\\main\\java\\com\\comprehensive\\practice\\company\\codility\\test\\hard\\ReverseStringExceptSpecialCharacter.java");
        Stream<String> value = Files.lines(path);
        Map<String, Long> wordCountMap = value.
                flatMap(e -> e.lines().map(k -> k.trim().split(" ")))
                .collect(Collectors.toList())
                .stream().flatMap(Stream::of).collect(Collectors.toList())
                .stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));


        Map<String, Long> ssss = value
                .flatMap(e -> e.lines().map(k -> k.trim().split(" ")))
                .flatMap(Stream::of)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
    }

    public static void main22(String[] args) throws IOException {
        Path path= Paths.get("D:\\roomno13\\comprehensive-prectice\\src\\main\\java\\com\\comprehensive\\practice\\company\\codility\\test\\easy\\ArrayListTest.java");
        Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
        Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" ")));
        List<String> listOfLines = words.collect(Collectors.toList());
        Map<String, Long> map = listOfLines.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }

    public static void main(String[] args) throws IOException {
        Path path= Paths.get("D:\\roomno13\\comprehensive-prectice\\src\\main\\java\\com\\comprehensive\\practice\\company\\codility\\test\\easy\\ArrayListTest.java");
        Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
        String stringArray = lines.collect(Collectors.joining(System.lineSeparator()));


    }


}
