package code;

import java.util.Arrays;
import java.util.Scanner;

public class july6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int digits[]=new int[n];
        for(int i=0;i<n;i++){
            digits[i]=sc.nextInt();
        }
        plusOne(digits);
    }
    public static int[] plusOne(int[] digits) {
        if(digits[digits.length-1]!=9){
            ++digits[digits.length-1];
            return digits;
        }
        int carry = 1;
        for(int i=digits.length-1;i>=0 ;i--){
            if(digits[i]+carry<10){
                digits[i]+=carry;
                return digits;
            }
            digits[i]=0;
        }
        if(carry==1){
            int array[]=new int[digits.length+1];
            Arrays.fill(array, 0);
            array[0]=1;
            return array;
        }
        return digits;
    }
}