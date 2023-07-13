package com.comprehensive.practice.company.codility.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
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

    public static void main(String[] args) {
        Map<Boolean, List<Employee>> ssss = getEmployeeList().stream().
                collect(Collectors.groupingBy(employee -> Math.ceil(employee.getSalary()%100) > 300, toList()));
        System.out.println(ssss);

        Map<Employee, List<Employee>> result = getEmployeeList().stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(groupingBy(Employee::getSalary, LinkedHashMap::new, toList()))
                .values().stream()
                .collect(toMap(l -> l.get(0), Function.identity()));
    }
}
