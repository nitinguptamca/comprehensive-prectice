package com.comprehensive.practice.company.codility.java8;

import com.comprehensive.practice.bean.People;
import com.comprehensive.practice.bean.Product;
import com.comprehensive.practice.utility.ReadFileUtility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompareFunctionality {
    public static void main(String[] args) {
        List<People> peopleList =getPeople();

        peopleList.stream().sorted(Comparator.comparing(People::getLastName)
                .thenComparing(People::getFirstName)
                .thenComparing(People::getEmail,
                        Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)))
                .limit(10)
                .collect(Collectors.toList());

        Comparator<People> peopleComparator = (p1, p2) -> p1.getDateOfBirth()
                .compareTo(p2.getDateOfBirth());

              /*  List<People> value = peopleList.stream()
                .sorted(Comparator.comparingInt(People::getIndex)
                        .thenComparing(People::getSex)
                )
                .limit(10)
                .collect(Collectors.toList());
*/
               // value=peopleList.stream()
                        //.sorted(
                      //  (s1,s2) -> s1.getDateOfBirth().compareTo(s2.getDateOfBirth()))
                       // .sorted(People::getDateOfBirth, Comparator.nullsLast(Comparator.reverseOrder()))
                         //       .limit(10)
                        //                .collect(Collectors.toList());

        List<People> value = peopleList.stream()
                .sorted(Comparator.comparing(People::getDateOfBirth, Comparator.nullsLast(Comparator.reverseOrder())))
                .limit(1000).collect(Collectors.toList());

        peopleList.stream().sorted(Comparator.nullsLast(
                (s1,s2) ->s1.getDateOfBirth().compareTo(s2.getDateOfBirth())
        )).collect(Collectors.toList());

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
