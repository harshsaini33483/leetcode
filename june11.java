package code;

import java.util.Scanner;

public class june11 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        sortColor(nums);
    }

    private static void sortColor(int[] nums) {
        int zero =0;
        int one =0;
        int two=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                ++zero;
                continue;
            }
            if(nums[i]==1){
                ++one;
                continue;
            }
            ++two;
        }
        int i=0;
        for(int j=0;j<zero;j++){
            nums[i]=0;
            ++i;
        }

        for(int j=0;j<one;j++){
            nums[i]=1;
            ++i;
        }

        for(int j=0;j<two;j++){
            nums[i]=2;
            ++i;
        }
    }
}