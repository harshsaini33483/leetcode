package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class aug6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        List<Integer> arr = findDuplicates(nums);
        for(int i:arr){
            System.out.println(i);
        }
        
    }
    public static List<Integer> findDuplicates(int[] nums) {
       List<Integer> ans = new ArrayList<>();
       for(int i=0;i<nums.length;i++){
            int nextEle = Math.abs(nums[i]);
            if(nums[nextEle-1]<0){
                ans.add(nextEle);
            }
            nums[nextEle-1]=- nums[nextEle-1];
       }
       return ans;
    }
}