package code;

import java.util.Scanner;

public class Solution1528 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        int indices[]=new int[str.length()];
        for(int i=0;i<str.length();i++){
            indices[i]=sc.nextInt();
        }
        restoreString(str, indices);
    }
    public static String restoreString(String s, int[] indices) {
        char ans []=new char[s.length()];
        for(int i=0;i<s.length();i++){
            ans[indices[i]]=s.charAt(i);
        }
        return new String(ans);
    }
}
