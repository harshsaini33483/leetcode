package code;

import java.util.Arrays;
import java.util.Scanner;

public class sep16 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nums[]=new int[sc.nextInt()];
        for(int i=0;i<nums.length;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(findMaximumXOR(nums));
        
    }
    public static int findMaximumXOR(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                System.out.println(nums[i]+" "+nums[j]+" "+Integer.toBinaryString(nums[i])+" "+Integer.toBinaryString(nums[j]));
                int currentMax = nums[i]^nums[j];
                System.out.println(Integer.toBinaryString(currentMax)+"   "+currentMax);
                if(currentMax>ans){
                    ans=currentMax;
                }
            }
        }
        // Arrays.sort(nums);
        // for(int i=0;i<nums.length-1;i++){
        //     int currentMax = nums[i]^nums[nums.length-1];
        //     if(currentMax> ans){
        //         ans = currentMax;
        //     }
        // }
        return ans;
    }
}
// 8 10 1000 1010
// 0010   2

// 8 2 1000 0010
// 1010   10

// 10 2 1010 0010
// 1000   8