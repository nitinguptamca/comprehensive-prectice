package com.comprehensive.practice.company.codility.test.hard;

/**
 * Write a method to count the number of 2s between 0 and n. Write a method to
 * count the number of 5s between 0 and n.
 *
 * @author nitin *************************************************************
 *         Picture a sequence of numbers: 0 1 2 3 4 5 6 7 8 9 -2s come 1 times
 *         10 11 12 13 14 15 16 17 18 19 -2s come 1 times 20 21 22 23 24 25 26
 *         27 28 29 -2s come 11 times ... 110 111 112 113 114 115 116 117 118
 *         119 -2s come 1 times 120 121 122 123 124 125 126 127 128 129 -2s come
 *         11 times
 **********************************************************
 *         So, if there are X 2s between 0 and 99, then we know there are 2x
 *         twos between 0 and 199. Between 0 and 299, we have 3x twos from the
 *         last two digits, and another 100 2s from the first digit. In other
 *         words, we can look at a number like this: f(513) = 5 * f(99) + f(13)
 *         + 100
 */
public class CountTheNumberOf2s {

    public static void main(String[] args) {
        System.out.println(countTheNumberof2(100));
    }

    public static int countof2s(int number){
        int remainder=0;
        int tempPower=0;
        int countOf2=0;
        int position=0;
        int power=1;
        while(number>0){
            remainder =number%10;
            tempPower = power/10;
            countOf2 =countOf2+remainder*position*tempPower;
            if(remainder==2){
               countOf2= countOf2+1;
            } else if (remainder>2) {
                countOf2=countOf2*power;
            }
            position++;
            power=power*10;
            number=number/10;
        }
        return countOf2;
    }

    private static int countTheNumberof2(int number) {
        int remainder =0;
        int tempPower=0;
        int countOf2s=0;
        int position=0;
        int power =1;
        while(number>0){
            remainder = number %10;
            tempPower = power/10;
            countOf2s =countOf2s+ remainder * position * tempPower;
            if(remainder==2){
                countOf2s+=1;
            }else if(remainder >2){
                countOf2s = countOf2s*power;
            }
            position++;
            power = power * 10;
            number = number /10;
        }
        System.out.println("countof2" + countOf2s);
        return countOf2s;
    }
}
