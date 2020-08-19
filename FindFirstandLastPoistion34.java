package code;

import java.util.Scanner;

public class FindFirstandLastPoistion34 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nums[]=new int[sc.nextInt()];
        for(int i=0;i<nums.length;i++){
            nums[i]=sc.nextInt();
        }
        int []ans = searchRange(nums, sc.nextInt());
        System.out.println(ans[0]+"  "+ans[1]);
    }
    public static int[] searchRange(int[] nums, int target) {
        int start = 0;
        int  end = nums.length;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target){
                int left = find(start, mid,target, nums, 0);
                int right = find(mid, end,target, nums, 1);
                return new int[]{left, right};
            }
            else if(nums[mid]<target){
                start =mid+1;
            }else{
                end =mid-1;
            }
        }
        return new int[]{-1, -1};
    }
    public static int find(int start, int end, int target, int []nums, int direction){
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                if(direction==0){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            } else if(nums[mid]<target){
                start =mid+1;
            }else{
                end =mid-1;
            }
        }
        if(direction==0){
            return start;
        }
        return end;
    }
    public static int[] alternateSolution(int nums[], int target){
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]<target){
                start = mid+1;
            }else if(nums[mid]>target){
                end = mid-1;
            }else{
                if(nums[start]!=target){
                    ++start;
                }
                else if(nums[end]!=target){
                    --end;
                }else{
                    break;
                }
            }
        }
        if(start>end){
            return new int[]{-1,-1};
        }
        return new int[]{start, end};
    }
}

// 5,7,7,8,8,10
