package code;

import java.util.Scanner;

public class Solution1221 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(balancedStringSplit(str));
    }
    public static int balancedStringSplit(String s) {
        int ans=0;
        int R=0;
        int L=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='R'){
                ++R;
            }else{
                ++L;
            }
            if(R==L){
                ++ans;
                R=0;L=0;

            }
        }
        return ans;
    }
}
