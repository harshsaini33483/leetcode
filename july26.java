package code;

import java.util.Scanner;

public class july26 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        addDigits(n);
    }
    public static int addDigits(int num) {
      if(num==0) return 0;
      return num%9;
    }
}