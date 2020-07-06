package code;

import java.util.Scanner;

public class june7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        int array[]=new int[sc.nextInt()];
        for(int i=0;i<array.length;i++){
            array[i]=sc.nextInt();
        }
        change(n, array);
    }
    public static int change(int amount, int[] coins) {
        int array[]=new int[amount+1];
        array[0]=1;
        for(int coin: coins){
            for(int i=coin;i<=amount;i++){
                array[i]=array[i]+array[i-coin];
            }
        }
        return array[amount];
    }
}