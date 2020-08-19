package code;

import java.util.Scanner;

public class BuyTimetoBuyandSellStockIII {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int prices[]=new int[sc.nextInt()];
        for(int i=0;i<prices.length;i++){
            prices[i]=sc.nextInt();
        }
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int leftProfit[]=new int[prices.length];
        int rightProfit[]=new int[prices.length];
        if(prices.length==0){
            return 0;
        }
        int buy =prices[0];
        for(int i=1;i<prices.length;i++){
            if(buy>prices[i]){
                buy= prices[i];
            }
            leftProfit[i]= Math.max(leftProfit[i-1], prices[i]-buy);
        }
        buy =prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            if(buy<prices[i]){
                buy= prices[i];
            }
            rightProfit[i]= Math.max(rightProfit[i+1],buy-prices[i]);
        }

        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            if(leftProfit[i]+rightProfit[i]>maxProfit){
                maxProfit= leftProfit[i]+rightProfit[i];
            }
        }
        return maxProfit;
    }
}