package com.comprehensive.practice.mobikwik.com;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Student {
    private String department;
    private String studentName;
    private double percentage;
    @Override
    public String toString(){
        return "\n dept "+department+" studentName "+studentName+ " percentage "+percentage;
    }
}

public class Top3StudentFromAll3Dept {

    Comparator<Student> percentageSort = (s1,s2 ) -> s1.getPercentage() >s2.getPercentage()?-1:1;


    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("science", "aaaa", 99.87));
        studentList.add(new Student("science", "bbb", 98.87));
        studentList.add(new Student("science", "cccc", 97.87));
        studentList.add(new Student("science", "dddd", 96.87));
        studentList.add(new Student("science", "eeeee", 95.87));
        studentList.add(new Student("science", "ffff", 94.87));
        studentList.add(new Student("science", "gggg", 93.87));

        studentList.add(new Student("Maths", "hh", 99.87));
        studentList.add(new Student("Maths", "iii", 98.87));
        studentList.add(new Student("Maths", "jjjj", 97.87));
        studentList.add(new Student("Maths", "kkk", 96.87));
        studentList.add(new Student("Maths", "lll", 95.87));
        studentList.add(new Student("Maths", "mmm", 94.87));
        studentList.add(new Student("Maths", "nnn", 93.87));

        studentList.add(new Student("physics", "oooo", 99.87));
        studentList.add(new Student("physics", "ppp", 98.87));
        studentList.add(new Student("physics", "qqq", 97.87));
        studentList.add(new Student("physics", "rrrr", 96.87));
        studentList.add(new Student("physics", "sss", 95.87));
        studentList.add(new Student("physics", "tttt", 94.87));
        studentList.add(new Student("physics", "uuu", 93.87));


        List<List<Student>> aaawwa = getResult(studentList);
       /// System.out.println(aaawwa);



    }

   public static List<List<Student>> getResult(List<Student> studentList){

        Map<String,List<Student>>deptMap=  studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartment));
       
        Comparator<Student> byPercentage = (Student obj1,Student obj2) -> obj1.getPercentage() >
                obj2.getPercentage()? -1:1;

        List<List<Student>>  sortedList = new ArrayList<>();
       deptMap.entrySet().stream()
               .forEach(stringListEntry -> {
                   List<Student> ssss = stringListEntry.getValue().stream()
                           .sorted(byPercentage).limit(3).collect(Collectors.toList());
                   sortedList.add(ssss);
               });

       List<List<Student>> sssss = studentList.stream().collect(Collectors.groupingBy(Student::getDepartment)).entrySet()
               .stream().map(ss -> ss.getValue().stream().sorted(byPercentage).limit(3).collect(Collectors.toList()))
               .collect(Collectors.toList());

       System.out.println(sssss);




       return sortedList;

    }
}
