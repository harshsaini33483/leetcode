package code;

import java.util.Scanner;

public class sep15 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(lengthOfLastWord(str));
    }
    public static int lengthOfLastWord(String s) {
        s=s.trim();
        int ans =0,i=s.length()-1;
        while(i>=0 && s.charAt(i)!=' '){
            ++ans;
            --i;
        }return ans;
    }
}
