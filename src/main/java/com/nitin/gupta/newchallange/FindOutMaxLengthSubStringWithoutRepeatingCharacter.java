package com.nitin.gupta.newchallange;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *  input  str="SDFAIUERDSFSEWRZXCWERFHSEKLJ";
 */
public class FindOutMaxLengthSubStringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String input  ="NITINGUPTA";
        System.out.println( findOutNonRepeatableMaxLengthSubString(input));
        int[] arrary ={4,1,2};
        /**
         * 4,1,2
         * 4+1 ,1 ,2
         * 5,5+1,2
         * 5,6,6+2
         * 19
         */
       int sum= Arrays.stream(outputASdefine(arrary)).boxed().reduce(0 ,(a ,b) ->a+b);
        System.out.println(sum);
    }

    private static int[] outputASdefine(int[] arrary) {
        if(arrary.length<=1){
            return arrary;
        }else{
            arrary[0] =arrary[0]+arrary[1];
            for (int i = 1; i < arrary.length; i++) {
                arrary[i]=arrary[i-1]+arrary[i];
            }
            return  arrary;
        }
    }

    static String findOutNonRepeatableMaxLengthSubString(String input){
       String output="";
        for (int i = 0; i < input.length(); i++) {
            for (int j = i+1; j < input.length(); j++) {
                String str =  input.substring(i ,j);
                String expectedEEmptyString        = str
                        .chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue() != 1)
                        .map(Map.Entry::getKey)
                                 .map(String::valueOf)
                                 .collect(Collectors.joining());

               if(expectedEEmptyString.isBlank()) {
                   output = str.length() > output.length() ? str : output;
               }else break;
            }
        }

        return output;
    }
}