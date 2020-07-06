package code;

import java.text.DecimalFormat;
import java.util.Scanner;

public class june8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        System.out.println(isPowerOfTwo(n));
    }
    public static boolean isPowerOfTwo(int n) {
        double num = (Math.log(n)/Math.log(2));
        DecimalFormat df = new DecimalFormat("#.#########"); 
        double newValue = Double.valueOf(df.format(num));   
        System.out.println(newValue);
        long checkNum = (long)num;
        
        if(checkNum-newValue!=0){
            return false;
        }return true;
    }
}