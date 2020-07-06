package code;

import java.util.Scanner;

public class june16 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str =sc.nextLine();
        System.out.println(validIPAddress(str));
        ;
    }
    public static String validIPAddress(String IP) {
        if(IP.indexOf('.')>-1 && countDecimal(IP)){
            String splitString []=IP.split("\\.");
            if(splitString.length==4){
                for(String i: splitString){
                    if(i.equals("") || (i.charAt(0)=='0' && i.length()>1) || i.length()>3 || Integer.parseInt(i)>=256 ){
                        return "Neither";
                    }
                }
                return "IPv4";
            }
        }else if(IP.indexOf(':')>-1 && countSemiColon(IP)){

            String splitString[] = IP.split("\\:");
            if(splitString.length==8){
                for(String i: splitString){
                    if(i.equals("") || i.length()>=5){
                        return "Neither";
                    }
                }
                return "IPv6";
            }
        }
        return "Neither";
    }

    private static boolean countSemiColon(String iP) {
        int count=0;
        for(char i: iP.toCharArray()){
            if(i==':'){
               ++count;
            }
            if((i>'F' && i<='Z') || (i>'f' && i<='z') ){
                return false;
            }
            if((i!=':') && !(i>='0' && i<='9') && !(i>='a' && i<='f') && !(i>='A' && i<='F')){
                return false;
            }
            if(count>7){
                return false;
            }
        }
        return true;
    }

    private static boolean countDecimal(String iP) {
        int count=0;
        for(char i: iP.toCharArray()){
            if(i=='.'){
               ++count;
            } if(i!='.' && !Character.isDigit(i)){
                return false;
            }
            if(count>3){
                return false;
            }
        }
        return true;
    }
}