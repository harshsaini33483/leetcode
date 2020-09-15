package code;

import java.util.Scanner;

public class sep11 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nums[]=new int[sc.nextInt()];
        for(int i=0;i<nums.length;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        // int ne = 0,ze=0,po=0;
        // int totalSum=1;
        // // If array contain even no. of  -ve no.
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]<0){++ne;}
        //     else if(nums[i]==0){++ze;}
        //     else{++po;}
        //     totalSum*=nums[i];
        // }
        // if(ze==0){
        //     // if all positive
        //     if(po==nums.length || ne%2==0){
        //         return totalSum;
        //     }
        // }
        // int prod[]=new int[nums.length];
        // int currentMax = nums[0];
        // prod[0]=nums[0];
        // for(int i=1;i<nums.length;i++){
        //     prod[i]=Math.max(nums[i]*prod[i-1],Math.max(nums[i]*nums[i-1],nums[i]));
        //     if(prod[i]>=currentMax){
        //         currentMax = prod[i];
        //     }
        // }
        int currentMax = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int intmax = nums[i];
            int tempMax = nums[i];
            for(int j=i+1;j<nums.length;j++){
                tempMax = tempMax* nums[j];
                    if(tempMax>intmax){
                        intmax =tempMax;
                    }
            }
            if(currentMax<intmax){
                currentMax =intmax;
            }
        }
        return currentMax;
        
    }
    public static int anotherSolution(int nums[]){
        int n = nums.length;
        int maxInt = nums[0];
        int minInt = nums[0];
        int ans =maxInt;
        for(int i=1;i<n;i++){
            if(nums[i] < 0){ int tmp = maxInt; maxInt = minInt; minInt = tmp;}
            maxInt = Math.max(nums[i],nums[i]*maxInt);
            minInt = Math.max(nums[i], nums[i]*minInt);
            ans =Math.max(ans, maxInt);

        }
        return ans;
    }
}
//[1,0,-1,2,3,-5,-2]=10
//[0,-1,0,-9,-5,1,6]