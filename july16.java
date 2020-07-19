package code;

import java.util.Scanner;

public class july16 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x= sc.nextInt();
        int n =sc.nextInt();
        System.out.println(myPow(x, n));
    }
    public static  double myPow(double x, int n) {
        return powUtil(x,n);
    }
    public static double powUtil(double x, int n){
        if(n==0){
            return 1.0;
        }if(n==1){
            return x;
        }
        if(n<0){
            return powUtil(1/x, -n);
        }
        double ans = powUtil(x*x, n/2);
        if(n%2==1){ans*=x;}
        return ans;
    }
}