package code;

import java.util.Arrays;
import java.util.Scanner;

public class june10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int array[]=new int[n];
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(searchInsert(array, target));
    }
    public static int searchInsert(int[] nums, int target) {
        int targetIndex= Arrays.binarySearch(nums,target);
        if(targetIndex<0){
            return (targetIndex * -1) -1;
        }return targetIndex;
    }
}