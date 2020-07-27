package code;

import java.util.Scanner;

public class mininSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        System.out.println(findMin(nums));
        
    }
    public static int findMin(int[] nums) {
        int start=0;
        int end = nums.length-1;
        
        if(nums.length==1){
            return nums[0];
        }
        if(nums[start]<nums[end]){
            return nums[start];
        }
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            else if(nums[0]<nums[mid]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
}

//3 4 5 6 7 1 2