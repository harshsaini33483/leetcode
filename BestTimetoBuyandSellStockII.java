package code;

import java.util.Scanner;

public class BestTimetoBuyandSellStockII {
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
        int maxProfit = 0;
        int bestDay =Integer.MAX_VALUE;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]<bestDay){
                bestDay = prices[i];
            }
            maxProfit = Math.max(maxProfit, Math.max(prices[i+1]-bestDay, prices[i+1]-prices[i]+maxProfit));
        }
        return maxProfit;
    }
}