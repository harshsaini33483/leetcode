package code;

import java.util.HashMap;
import java.util.Scanner;

public class LongestPanlidrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(longestPalindrome(str));
        
    }
    public static String longestPalindrome(String s) {
      return optimizeAns(s);
    }
    public static String bruteForce(String s){
        if(s.length()==1){
            return s;
        }
        String ans="";
        for(int i=0;i<s.length();i++){
            for(int j=s.length()-1;j>=i;j--){
                if(s.charAt(i)==s.charAt(j) && j-i>=ans.length()){
                    int start=i;
                    int end =j;
                    boolean ok=true;
                    while(start<=end){
                        if(s.charAt(start)!=s.charAt(end)){
                            ok=false;
                            break;
                        }
                        ++start;
                        --end;
                    }
                    if(ok){
                        String currAns = s.substring(i, j+1);
                        if(ans.length()<currAns.length()){
                            ans= currAns;
                        }
                    }
                }
            }
        }
        return ans;
    }
    public static String optimizeAns(String s){
        int charDP[][]=new int[s.length()][s.length()];

        return s;
    }
}