package code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class aug21 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        int A[]= new int[n];
        for(int i=0;i<n;i++){
            A[i]=sc.nextInt();
        }
        int ans[]=sortByParity(A);
        for(int i:ans){
            System.out.println(i);
        }
    }
    public static int[] sortByParity(int A[]){
       // 0 and 1 type of question
       int index=0,val=0;
       for(int i=0;i<A.length;i++){
           if((A[i]&1)!=1){
               val = A[index];
               A[index]=A[i];
               A[i]= val;
               index++;
           }
       }
        return A;
    }
}