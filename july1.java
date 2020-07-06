package code;

import java.util.Scanner;

public class july1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        july1 obj =new july1();
        System.out.println(obj.arrangeCoins(n));
    }
    public int arrangeCoins(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        long start =0;
        long end = (long)n;
        while(start<=end){
            long mid = start+(end-start)/2;
            long sum = (mid*(mid+1))/2;
            if(n==sum){
                return (int)mid;
            }
            if(sum>n){
                end=mid-1;
            }else{
                start = mid+1;
            }
        }
        return (int)start-1;
    }
}