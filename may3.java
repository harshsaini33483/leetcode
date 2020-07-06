package code;

import java.util.Scanner;

public class may3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String str= Integer.toString(n,2);
        String ar="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                ar+='0';
            }else{
                ar+='1';
            }
        }
        System.out.println(Integer.parseInt(ar,2));
    }
}