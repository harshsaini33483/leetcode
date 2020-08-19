package code;

import java.util.Scanner;

public class aug10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s =sc.nextLine();
        System.out.println(titleToNumber(s));
    }
    public static int titleToNumber(String s) {
        int ans = 0;
        for(int i=s.length()-1;i>=0;i--){
            int powSum = (int)Math.pow(26, (s.length()-1-i));
            int sum = s.charAt(i)-'@';
            ans+=(powSum*sum);
        }
        return ans;
    }
}