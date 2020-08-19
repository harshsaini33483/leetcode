package code;

import java.util.Scanner;

public class aug17 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int candies = sc.nextInt();
        int num_people = sc.nextInt();
        distributeCandies(candies, num_people);
    }   
    public static int[] distributeCandies(int candies, int num_people) {
        if(num_people==1){
            return new int[]{candies};
        }
        int ans []=new int[num_people];
        int i=0;
        int turn =0;
        int lastCandy=1;
       while(candies>0){
           int reqCandy = (turn*num_people)+lastCandy;
           if(reqCandy<=candies){
            ans[i]+=(reqCandy);
           }else{
               ans[i]+=candies;
           }
          
           candies-=reqCandy;
        
           if(++i>=num_people){
               i=i%num_people;
               lastCandy=0;
               ++turn;
           }
           ++lastCandy;
       }
       return ans;
    }
}