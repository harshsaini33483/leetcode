package code;

import java.util.Scanner;

public class june9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        isSubsequence(s, t);
    }
    public static boolean isSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int i = 0,j=0;
        for(;j<tlen && i<slen;j++){
            if(s.charAt(i)==t.charAt(j)){
                ++i;
            }
        }     
        if(i<slen){
            return false;
        }
        return true;
    }
}