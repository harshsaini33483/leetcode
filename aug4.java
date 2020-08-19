package code;

import java.util.Scanner;

public class aug4 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int num =sc.nextInt();
        System.out.println(isPowerOfFour(num));
        
    }


    public static boolean isPowerOfFour(int num) {
        
       
        if(num<=0){
            return false;

        }
        double no = Math.log(num)/Math.log(4);
        int intNo = (int)no;
        if(no-intNo>0.00000000){
            return false;
        }return true;
    }
}