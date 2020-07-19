package code;

import java.util.Scanner;

public class july15 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s =  sc.nextLine();
        reverseWords(s);
    }
    public static String reverseWords(String s) {
        if(s.length()<1){
            return s;
        }
        char lastChar=s.charAt(0);
        StringBuilder ans= new StringBuilder();
        String splitString[]=s.split(" ");
        for(int i=splitString.length-1;i>=0;i--){
            if(splitString[i].trim().equals("")){
                continue;
            }
            ans.append(splitString[i]+" ");
        }
        return ans.toString().trim();
    }
}