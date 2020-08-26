package code;

import java.util.Arrays;
import java.util.Scanner;

public class aug25 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        int days[]=new int[n];
        for(int i=0;i<n;i++){
            days[i]=sc.nextInt();
        }
        int cost[]=new int[3];
        cost[0]=sc.nextInt();
        cost[1]=sc.nextInt();
        cost[2]=sc.nextInt();
        System.out.println(mincostTickets(days, cost));
        
    }
    public static int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int dp[]=new int[days.length+1];
        Arrays.fill(dp, 0);
        for(int i=n-1;i>=0;i--){
            int day7=i;
            int day30 =i;
            while(day7<n && days[day7] < days[i]+7){
                ++day7;
            }
            while(day30<n && days[day30] < days[i]+30){
                ++day30;
            }
            dp[i] = Math.min(dp[i+1]+costs[0], Math.min(dp[day7]+costs[1], dp[day30]+costs[2]));
        }
        return dp[0];
    }
}