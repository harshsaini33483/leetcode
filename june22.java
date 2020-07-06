package code;

import java.util.Scanner;

public class june22 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        singleNumber(arr);
    }
    public static int singleNumber(int[] nums) {
        int one =0,two=0;
        for(int i=0;i<nums.length;i++){
            one  = (one ^ nums[i]) & ~two;
            two  = (two ^ nums[i]) & ~one;

        }
        return one;
    }
}