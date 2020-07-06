package code;

import java.util.Arrays;
import java.util.Scanner;

public class june18 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int array[]=new int[n];
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        Arrays.sort(array);
        System.out.println(hIndex(array));
    }
    public static int hIndex(int[] citations) {
        int n = citations.length;
        int start = 0;
        int end = n-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(citations[mid]==n-mid){
                start=mid+1;
            }
            else if(citations[mid]>n-mid){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return n-start;
    }
}