package code;

import java.util.Scanner;

public class BestTimetoBuyandSellStock121 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int prices[]=new int[sc.nextInt()];
        for(int i=0;i<prices.length;i++){
            prices[i]=sc.nextInt();
        }

        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
      
        if(prices.length==0){
            return 0;
        }
        int profit =0;
        int buy =prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]-buy>profit){
                profit=prices[i]-buy;
            }
            if(buy>prices[i]){
                buy = prices[i];
            }
        }
        return profit;
    }
}