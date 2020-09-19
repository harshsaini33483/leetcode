package code;

import java.util.Scanner;

public class Solution1395 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nums[]=new int[sc.nextInt()];
        for(int i=0;i<nums.length;i++){
            nums[i]=sc.nextInt();
        }
        numTeams(nums);
    }
    public static int numTeams(int[] rating) {
        int ans=0;
        int minLeft[]=new int[rating.length];
        int maxLeft[]=new int[rating.length];
        int minRight[]=new int[rating.length];
        int maxRight[]=new int[rating.length];

        for(int i=1;i<rating.length-1;i++){
            for(int j=0;j<i;j++){
                if(rating[j]>rating[i]){
                    ++maxLeft[i];
                }else{
                    ++minLeft[i];
                }
            }
            for(int j=i+1;j<rating.length;j++){
                if(rating[j]>rating[i]){
                    ++maxRight[i];
                }else{
                    ++minRight[i];
                }
            }
        }
        for(int i=1;i<rating.length;i++){
            ans+=(minLeft[i]*maxRight[i])+(minRight[i]*maxLeft[i]);
        }
        return ans;
    }
}
//[2,5,3,4,1]