package code;

import java.util.Scanner;

public class pivotIndex {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(pivotIndex(nums));
    }
    public static int pivotIndex(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
     
            sum+=nums[i];
        } 
        int prefixSum =0;
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            if(sum-prefixSum==0){
                return i;
            }
            sum -=nums[i];
        }
        return -1;
    }
}