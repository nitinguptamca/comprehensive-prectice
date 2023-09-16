package com.comprehensive.practice.Exception;

public class TestingException {
    public static void main(String[] args) {
        try{
            throw new CustomException();
        }catch(CustomException ex){
            System.out.println(2);
        }catch(RuntimeException ex){
            System.out.println(1);
        }catch(Exception ex){
            System.out.println(3);
        }
    }
}
