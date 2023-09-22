package com.comprehensive.practice.company.codility.java8;

import com.comprehensive.practice.bean.Employee;
import com.comprehensive.practice.bean.People;
import com.comprehensive.practice.utility.ReadFileUtility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class CompareFunctionality {

    public static void main(String[] args) {
        String[] ssss ={"a","v","s","w","n"};
        Arrays.stream(ssss).sorted(String::compareTo).collect(toList());
        Arrays.stream(ssss).sorted().collect(toList());
    }

    public static void mainqqqq(String[] args) {
        Comparator<Integer>  intComp = Comparator.naturalOrder();
        Comparator<String>   strComp = String::compareTo;
        Comparator<Integer>  intcomp1 = (a ,b) -> a-b;
        Comparator<Integer>  intcomp2 = (a ,b) -> a.compareTo(b);
        Comparator<Integer>  intcomp3 = Integer::compareTo;
        int[]  arr = {1,5,3,8,3,6,3};

        List<Integer> dddddd = Arrays.stream(arr).sorted().boxed().collect(toList());
        List<Integer> qqq = Arrays.stream(arr).boxed()
                .sorted((a, b) -> Integer.compare(a, b)).collect(toList());
        List<Integer> qqq11;
        qqq11 = Arrays.stream(arr).boxed().sorted(Comparator.comparingInt(a -> a)).collect(toList());
        Arrays.stream(arr).boxed().sorted(Integer::compareTo).collect(toList());
        List<Integer> jkfls = Arrays.stream(arr).sorted().boxed().collect(toList());
        Arrays.stream(arr).boxed().sorted((a, b) -> a - b).collect(toList());
        Arrays.stream(arr).boxed().sorted((a,b) -> a-b).collect(toList());
        Arrays.stream(arr).boxed().sorted(intComp).collect(toList());
        Arrays.stream(arr).boxed().sorted(Integer::compareTo).collect(toList());

        Arrays.stream(arr).boxed().sorted((a,b) -> a.compareTo(b)).collect(toList());
        Arrays.stream(arr).boxed().sorted(Collections.reverseOrder(Integer::compareTo)).collect(toList());
        Arrays.stream(arr).boxed().sorted(intcomp1.reversed()).collect(toList());
        Arrays.stream(arr).boxed().sorted(Comparator.naturalOrder()).collect(toList());
        List<Integer> sssder = Arrays.stream(arr).boxed()
                .sorted(Collections.reverseOrder(intcomp3)).collect(toList());
    }

    public static void main123(String[] args) {
        List<People> peoples = getPeople();
        int nanoseconds = Instant.now().getNano();
        Map<Integer, List<People>> bbbb = peoples.parallelStream()
                .collect(Collectors.groupingBy(People::getIndex));
        int nanoseconds2 = Instant.now().getNano();
        System.out.println(nanoseconds2 - nanoseconds);
        peoples.stream().sorted(Comparator.comparing(People::getDateOfBirth).reversed()
                .thenComparing(People::getEmail).reversed()
        ).collect(toList());

    }
    public static void main13131(String[] args) {
        List<People> peopleList =getPeople();

        String[]  strArray = {"we","a","apple","aggro","o","i","h","gh","df","qasw","re","cd","mbvn","rt"};


        //Arrays.stream(strArray).sorted(String::compareTo).collect(Collectors.toList());
        TreeMap<Character, String> ssss = Arrays.stream(strArray)
                .collect(Collectors.toMap(aaa -> aaa.charAt(0), a ->a ,
                        (existing, replacement) -> existing, TreeMap::new));
        Map<Character, List<String>> kkkkk = Arrays
                .stream(strArray)
                .sorted(String::compareTo)
                .collect(Collectors.groupingBy(a -> a.charAt(0) ,toList()));

        Arrays
                .stream(strArray)
                .sorted(String::compareTo)
                .collect(Collectors.groupingBy(a -> a.charAt(0) ,toSet()));

        Map<Object, List<String>> sssssss = Arrays
                .stream(strArray)
                .sorted(String::compareTo)
                .collect(Collectors.groupingBy(a -> a.charAt(0), toList()));

        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        Map finalMap = new HashMap<>();
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed())
                .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);

        peopleList.stream().sorted(Comparator.comparing(People::getJobTitle,
                Comparator.nullsLast(String::compareTo)).reversed()).collect(toList());

        List<People> hjsfdkhskhfkds = peopleList.stream().sorted
                        (Comparator.comparing(People::getLastName,
                                        Comparator.nullsLast(String::compareTo))
                                .reversed())
                .collect(Collectors.toUnmodifiableList());
        System.out.println(hjsfdkhskhfkds);

        peopleList.stream().sorted( Comparator.comparing(People::getDateOfBirth
                ,Comparator.nullsLast(LocalDate::compareTo)).reversed()).collect(toList());
        peopleList.stream().sorted(Collections.reverseOrder(Comparator.comparing(People::getDateOfBirth
                ,Comparator.nullsFirst(LocalDate::compareTo)))).collect(toList());

        peopleList.stream().sorted(Comparator.comparing(People::getLastName)
                .thenComparing(People::getFirstName)
                .thenComparing(People::getEmail,
                        Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)))
                .limit(10)
                .collect(toList());

        peopleList.stream().sorted(Comparator.comparing(People::getFirstName)
                .thenComparing(People::getLastName)
                .thenComparing(People::getDateOfBirth , Comparator.nullsFirst(LocalDate::compareTo))
                .reversed()
        ).limit(10).collect(toList());


        peopleList.stream().sorted(Comparator.comparing(People::getLastName)
                        .thenComparing(People::getFirstName)
                        .thenComparing(People::getEmail,
                                Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)))
                .limit(10)
                .collect(toList());


        Comparator<People> peopleComparator = (p1, p2) -> p1.getDateOfBirth()
                .compareTo(p2.getDateOfBirth());

        Comparator<Integer>  intComp = Comparator.naturalOrder();
        int[]  arr = {1,5,3,8,3,6,3};
        List<Integer> qqq = Arrays.stream(arr).boxed()
                .sorted((a, b) -> Integer.compare(a, b)).collect(toList());
        List<Integer> qqq11;
        qqq11 = Arrays.stream(arr)
                .boxed().sorted(Comparator.comparingInt(a -> a)).collect(toList());
        List<Integer> jkfls = Arrays.stream(arr).sorted().boxed().collect(toList());
        Arrays.stream(arr).boxed().sorted((a, b) -> a - b).collect(toList());

        peopleList.stream().sorted((p1 ,p2) ->
            p1.getEmail().compareTo(p2.getEmail()))
                .collect(toList());

               List<People> value = peopleList.stream()
                .sorted(Comparator.comparingInt(People::getIndex)
                        .thenComparing(People::getSex)
                )
                .limit(10)
                .collect(toList());


        List<People> value1 = peopleList.stream()
                .sorted(Comparator.comparing(People::getDateOfBirth,
                        Comparator.nullsLast(Comparator.reverseOrder())))
                .limit(1000).collect(toList());

        peopleList.stream().sorted(Comparator.nullsLast(
                (s1,s2) ->s1.getDateOfBirth().compareTo(s2.getDateOfBirth())
        )).collect(toList());

        System.out.println(value);
    }

    public static void main1(String[] args) {
        List<Map<String,String>> list = new ArrayList<>();
        Comparator<Map<String, String>> mapComparator =
                (Map<String, String> m1, Map<String, String> m2) -> m1.get("date").compareTo(m2.get("date"));
        Collections.sort(list, mapComparator);

    }

  static public List<People> getPeople(){
      ReadFileUtility readFileUtility= new ReadFileUtility();
      return  readFileUtility.getRecordFromLine();
    }
    /**
     * 4 ways to compare LocalDate
     * <Li>
     * <OL>Using java.util.Comparator</OL>
     * <OL>Using Lambda expression</OL>
     * <OL>Using Method References</OL>
     * <OL>Using Stream API</OL>
     * </Li>
     */
    class DateOfBirthComparator implements Comparator<People> {
        @Override
        public int compare(People p1, People p2) {

            return p1.getDateOfBirth().compareTo(p2.getDateOfBirth());
        }
    }
}


class ApplyOperationEmployee {
    private static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee("nitin", 43, 245999.8d));
        employees.add(new Employee("sachin", 43, 245239.8d));
        employees.add(new Employee("mark", 67, 35999.8d));
        employees.add(new Employee("vandna", 12, 298999.8d));
        employees.add(new Employee("moumita", 46, 9865999.8d));
        employees.add(new Employee("nitu", 46, 8654999.8d));
        employees.add(new Employee("sangeeta", 56, 3245999.8d));
        employees.add(new Employee("hira", 23, 2345999.8d));
        employees.add(new Employee("panna", 12, 99d));
        employees.add(new Employee("teena", 12, 10d));
        employees.add(new Employee("reena", 99, 125999.8d));

    }

    public static void main(String[] args){
        String sss = "uiwyqwieryq";
        Map<Character, List<Character>> ssssss = sss.chars().mapToObj(d -> (char) d).collect(Collectors.groupingBy(Function.identity()));

        Path path = Paths.get("/Users/nitinguptamca/github/comprehensive-prectice/src/main/java/com/comprehensive/practice/company/codility/java8/FlatMap/Order.java");
        Map<String, Long> hhh;
        Map<String, Long> hhh1;
        try (Stream<String> lines = Files.lines(path)) {

            lines.flatMap( e ->e.lines().map(e1 ->e1.split(" ")))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.groupingBy(Function.identity() ,Collectors.counting()));

            hhh = lines.flatMap(line -> line.lines().map(e -> e.split(" ")))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            hhh1 = lines.flatMap(line -> line.lines()
                    .map(e -> e.split(" ")))
                    .flatMap(Stream::of)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        }catch (IOException e){
            e.getMessage();
        }


    }

    public static void main12313(String[] args) {
        List<Employee> ssss = employees.stream().sorted((e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                if (e1.getSalary() > e2.getSalary()) return -1;
                else return 1;
            } else if (e1.getAge() > e2.getAge()) return 1;
            else return -1;
        }).collect(toList());
        System.out.println(ssss);

        List<Employee> kkkkkk = employees.stream().sorted(
                Comparator.comparing(Employee::getAge)
                        .thenComparing(Employee::getSalary)
        ).collect(toList());
    }


    public static void main1(String[] args) {



        System.out.println();

        //sort by salary
        List<Employee> listsored = employees
                .stream()
                // option1   //.sorted(Comparator.comparing(Employee::getSalary ,Comparator.nullsFirst(Comparator.reverseOrder())))
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .collect(toList());
        System.out.println(listsored);

        List<Employee> sortedList = listsored.stream()
                .sorted((o1, o2) -> {
                    if(o1.getAge() == o2.getAge())
                        return o1.getName().compareTo(o2.getName());
                    else if(o1.getAge() > o2.getAge())
                        return 1;
                    else return -1;
                })
                .collect(toList());

        List<String> list = Arrays.asList("John", "Mark", "Robert", "Lucas", "Brandon");
        List<String> sortedList1 = list.stream().sorted().collect(toList());

        sortedList1 = list.stream()
                .sorted(Collections.reverseOrder())
                .collect(toList());
        listsored.sort(Comparator.comparing(Employee::getAge, Comparator.nullsLast(Comparator.naturalOrder())));
        listsored.sort(Comparator.comparing(Employee::getAge, Comparator.nullsLast(Comparator.reverseOrder())));

    }
}

