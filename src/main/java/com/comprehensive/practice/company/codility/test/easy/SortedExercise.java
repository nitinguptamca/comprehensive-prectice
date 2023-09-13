package com.comprehensive.practice.company.codility.test.easy;

import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedExercise {

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static class User{
        private int sessionTime;
        private String userid;
        private String resource;
    }
    public static void main(String[] args) {
        String[][] logs = {
                {"200", "user1", "resource1"},
                {"200", "user3", "resource3"},
                {"100", "user2", "resource2"},
                {"500", "user5", "resource5"},
                {"700", "user7", "resource7"},
                {"900", "user9", "resource9"},
                {"1300", "user3", "resource3"},
                {"1200", "user2", "resource2"},
                {"1700", "user7", "resource7"},
                {"1500", "user5", "resource5"},
                {"400", "user1", "resource1"}
        };
        List<User>  sorted    = getSortedUser(logs);
        System.out.println(Arrays.toString(sorted.toArray()));
    }

   static public List<User> getSortedUser(String[][] logs){
       List<User> users = new ArrayList<>(logs.length);
       for (int i = 0; i < logs.length; i++) {
           users.add(new User(Integer.parseInt(logs[i][0]), logs[i][1],logs[i][2]));
       }
        return  users.stream().sorted(
                Comparator.comparingInt(User::getSessionTime).thenComparing(User::getUserid).reversed()
        ).collect(Collectors.toUnmodifiableList());
    }
}
