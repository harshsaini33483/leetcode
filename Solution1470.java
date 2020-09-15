package code;

import java.util.Scanner;

public class Solution1470 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        int l = sc.nextInt();
        shuffle(nums, l);
    }
    public static int[] shuffle(int[] nums, int n) {
        int i=0,j=n, k=0;
        int ans[]=new int[nums.length];
        while(i<n && j<nums.length){
            if(k%2==0){
                ans[k]=nums[i];
                ++i;
                ++k;
            }else{
                ans[k]=nums[j];
                ++j;
                ++k;
            }
        }
        while(i<n){
            ans[k]=nums[i];
            ++i;++k;
        }while(j<nums.length){
            ans[k]=nums[j];
            ++k;
            ++j;
        }
        return ans;
    }
}
