package code;

import java.util.Scanner;

public class july31 {
   
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        sc.close();
        System.out.println(climbStairs(n));
        
    }

    public static int climbStairs(int n){
        if(n<=3){
            return n;
        }
        int stairs[]=new int[n+1];
        stairs[0]=0;
        stairs[1]=1;
        stairs[2]=2;
        for(int i=3;i<=n;i++){
            stairs[i]=stairs[i-1]+stairs[i-2];
        }
        return stairs[n];
    }
}