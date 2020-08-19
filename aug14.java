package code;

import java.util.Scanner;

public class aug14 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(longestPalindrome(s));
        
    }

    private static int longestPalindrome(String s) {
        int upperCase[]=new int[26];
        int lowerCase[]=new int[26];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                ++lowerCase[s.charAt(i)-'a'];
            }else{
                ++upperCase[s.charAt(i)-'A'];
            }
        }
        int ans =0;
        int maxOdd=0;
        for(int i=0;i<26;i++){
            if(upperCase[i]%2==0){
                ans+=upperCase[i];
            }else if(upperCase[i]!=0){
                if(maxOdd<upperCase[i]){
                    if(maxOdd!=0){
                        ans+=maxOdd-1;
                    }
                    maxOdd=upperCase[i];
                }else{
                    ans+=upperCase[i]-1;
                }
            }
            if(lowerCase[i]%2==0){
                ans+=lowerCase[i];
            }
            else if(lowerCase[i]!=0){
                if(maxOdd<lowerCase[i]){
                    if(maxOdd!=0){
                        ans+=maxOdd-1;
                    }
                    maxOdd=lowerCase[i];
                }else{
                    ans+=lowerCase[i]-1;
                }
            }
        }

        return ans+maxOdd;
    }

    public static int anotherSolution(String s){
        int ar[]=new int[128];
        for(char c: s.toCharArray()){
            ++ar[c];
        }
        int singles = 0;
        for(int count: ar){
            if(count%2!=0){
                ++singles;
            }
        }
        if(singles==0){
            return s.length();
        }else{
           return  s.length()-singles+1;
        }
    }

}