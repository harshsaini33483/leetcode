package code;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution1389 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        int nums[]=new int[n];
        int index[]=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();

        }for(int i=0;i<n;i++){
            index[i]=sc.nextInt();
        }
        createTargetArray(nums, index);
    }
    public static int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<index.length;i++){
            if(ans.size()<index[i]){
                ans.add(nums[i]);
            }else{
                ans.add(index[i],nums[i]);
            }
            
        }
        int inans[]=new int[ans.size()];
        for(int i=0;i<nums.length;i++){
            inans[i]=ans.get(i);
        }
        return inans;
    }
}
//0 4 1 3 2