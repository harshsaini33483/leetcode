package code;

import java.util.Scanner;

public class july23 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nums[]=new int[sc.nextInt()];
        for(int i=0;i<nums.length;i++){
            nums[i]=sc.nextInt();
        }
        singleNumber(nums);
    }
    public static int[] singleNumber(int[] nums) {
        int num=0;
        for(int i:nums){
            num^=i;
        }
        num &= -num;
        int ans[]=new int[2];
        ans[0]=0;
        ans[1]=0;
        for(int i:nums){
            if((num&i)==0){
                ans[0]^=i;
            }else{
                ans[1]^=i;
            }
        }
        return ans;
    }
}