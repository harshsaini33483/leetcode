package code;

import java.util.Scanner;

public class aug3 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {

        int i=0,j=s.length()-1;
        s = s.toUpperCase();
        while(i<=j){
            if((s.charAt(i)>='A' && s.charAt(i)<='Z' || s.charAt(i)>='0' && s.charAt(i)<='9') && ( s.charAt(j)>='0' && s.charAt(j)<='9' || s.charAt(j)>='A' && s.charAt(j)<='Z')){
                if(s.charAt(i)!=s.charAt(j)){
                    return false;
                }
                ++i;
                --j;
            
            }else if(!((s.charAt(i)>='A' && s.charAt(i)<='Z') || (s.charAt(i)>='0' && s.charAt(i)<='9'))){
                ++i;
            }else if(!((s.charAt(j)>='A' && s.charAt(j)<='Z') || (s.charAt(j)>='0' && s.charAt(j)<='9'))){
                --j;
            }
                
        }
        return true;

    }
}