package code;

import java.util.Scanner;

public class june4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        char array[]=str.toCharArray();
        reverseString(array);

    }
    public static void reverseString(char[] s) {
        int n =s.length;
        for(int i=0;i<n/2;i++){
            char temo = s[i];
            s[i]=s[n-i-1];
            s[n-i-1]=temo;
        }
    }
}