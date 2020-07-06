package code;

import java.util.Scanner;

public class may15 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        int array[]=new int[n];
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        System.out.println(maxSubarraySumCircular(array));
    }
    public static int maxSubarraySumCircular(int[] A) {
        //if all the number in array is in -ve
        int minNeg=A[0];
        boolean ok =true;
        for(int i=0;i<A.length;i++){
            if(A[i]>0){
                ok=false;
                break;
            }
            if(A[i]>minNeg){
                minNeg=A[i];
            }
        }
        if(ok){
            return minNeg;
        }

        //By Using Kadens Algo

        // Apply Max Kaden 
        int maxCurrent = A[0];
        int maxGlobal =A[0];
        for(int i=1;i<A.length;i++){
            maxCurrent = Math.max(A[i],A[i]+maxCurrent);
           
            if(maxCurrent>maxGlobal){
                maxGlobal=maxCurrent;
            }
        }
        int sum =0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
        }
        //Apply Min Kaden
        int minCurrent = A[0];
        int minGlobal =A[0];
        for(int i=1;i<A.length;i++){
            minCurrent = Math.min(A[i],A[i]+minCurrent);
            if(minGlobal>minCurrent){
                minGlobal= minCurrent;
            }
        }
        System.out.println(maxGlobal+" "+sum+" "+minGlobal);
        return Math.max(maxGlobal, sum-minGlobal);
    }
}