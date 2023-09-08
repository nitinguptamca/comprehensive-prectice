package com.comprehensive.practice.heakthRank;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * input
 * int[] A ={1,2,3,4,5,6};
 * get middle element
 * input scenarios 1 method (int N ,int[] A, int R,int L)
 *  input 1 :   N=6 ,A= {1,2,3,4,5,6} ,R=1 ,L=6   return middle element 3
 *  input 2 :   N=6 ,A= {1,2,3,4,5,6} ,R=2 ,L=4   return middle element 4
 *  input 3 :   N=6 ,A= {1,2,3,4,5,6} ,R=3 ,L=3   return middle element 4
 */
public class Array2 {
    public static void main(String[] args) {
        Array2 array2 = new Array2();
        int[] A ={1,2,3,4,5,6};
        int aa = array2.getMiddle(6 ,A, 1 ,6);
        System.out.println(aa);
        //assertEquals(3 ,aa);

        aa = array2.getMiddle(6 ,A, 2 ,4);
        System.out.println(aa);
      //  assertEquals(4 ,aa);

         aa = array2.getMiddle(6 ,A, 3 ,3);
        System.out.println(aa);
        assertEquals(5 ,aa);

    }

    public  int getMiddle(int N ,int[] A, int R,int L){
      int mid=  getMid(L);
      return A[mid+R];
    }
    int getMid(int L){
        int middle =0;
        if((L)% 2==0){
            middle = (L)/2 -1;
        }else{
            middle = (L)/2 ;
        }
        return middle -1;
    }


}
