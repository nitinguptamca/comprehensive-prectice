package com.comprehensive.practice.company.codility.test.easy;

public class GetLengthOfStringWithoutUsingExistingFunctionality {
    public static void main(String[] args) {
        String  str = "jfaskfasda";
        int counter=0;
        try{
            for(; str.charAt(counter)!='\0'; counter++) ;

        }catch(Exception e){
            //ArrayIndexOutOfBoundsException
            System.out.println("Length: " + counter);
        }
        System.out.println( length(str));
    }

    static int length(String p) {
        int i = 0;
        boolean flag = true;
        try {
            while (flag) {
                char ch = p.charAt(i);
                i++;
               // System.out.print("  " + ch);
            }

        } catch (Exception e) {
            return i;
        }
        return i;
    }
}
