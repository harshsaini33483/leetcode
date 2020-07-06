package code;

import java.util.HashMap;
import java.util.Scanner;

public class may12 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int array[]=new int[n];
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        System.out.println(singleNonDuplicate(array));
    }
    public static int singleNonDuplicate(int[] nums) {
        int start =0;
        int end =nums.length;
        while(start<=end){
            int mid=start+(end-start)/2;

            if(mid==0){
                if(nums[mid]!=nums[mid+1]){
                    return nums[mid];
                }else{
                    start = mid;
                }
            }else if(mid>=nums.length-1){
                if(nums[mid]!=nums[mid-1]){
                    return nums[mid];
                }else{
                    end =mid-1;
                }
            }else if(nums[mid]==nums[mid-1]){
                if((mid-1)%2==0){
                    start = mid+1;
                }else{
                    end =mid-1;
                }
            }else if(nums[mid]==nums[mid+1]){
                if((mid-nums.length-1)%2==0){
                    start = mid+1;
                }else{
                    end =mid-1;
                }

            }
            else{
                return nums[mid];
            }
        }
        return 0;
     
    }
}