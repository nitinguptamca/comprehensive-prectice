package com.comprehensive.practice.company.codility.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class PartitionByExample {

    @Setter
    @Getter
    @AllArgsConstructor
    static class Employee {
        private int id;
        private String name;
        private String designation;
        private String gender;
        private long salary;
    }

    public static List<Employee> getEmployeeList() {
        List<Employee> employeesList = new ArrayList<>();
        employeesList.add(new Employee(101, "Glady", "Manager", "Male", 25_00_000));
        employeesList.add(new Employee(102, "Vlad", "Software Engineer", "Female", 15_00_000));
        employeesList.add(new Employee(103, "Shine", "Lead Engineer", "Female", 20_00_000));
        employeesList.add(new Employee(104, "Nike", "Manager", "Female", 25_00_000));
        employeesList.add(new Employee(105, "Slagan", "Software Engineer", "Male", 15_00_000));
        employeesList.add(new Employee(106, "Murekan", "Software Engineer", "Male", 15_00_000));
        employeesList.add(new Employee(107, "Gagy", "Software Engineer", "Male", 15_00_000));

        return employeesList;
    }

    public static void main11(String[] args) {
       getEmployeeList().stream().
                collect(Collectors.groupingBy( Employee::getSalary));

    }

    public static void main(String[] args)
    {
        // creating an Integer stream
        Stream<Integer>
                s = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // using Collectors partitioningBy()
        // method to split the stream of elements into
        // 2 parts, greater than 3 and less than 3.
        Map<Boolean, List<Integer> >
                map = s.collect(
                Collectors.partitioningBy(num -> num %3==0));

        // Displaying the result as a map
        // true if greater than 3, false otherwise
        System.out.println("Elements in stream "
                + "partitioned by "
                + "less than equal to 3: \n"
                + map);
    }
}
