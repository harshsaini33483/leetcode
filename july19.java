package code;

import java.util.Scanner;

public class july19 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a = sc.nextLine();
        String b=sc.nextLine();
        System.out.println(addBinary(a,b));
        
    }
    public static String addBinary(String a, String b) {
        StringBuilder ans =new StringBuilder();
        int i=a.length()-1,j=b.length()-1,carry=0;
        while(i>=0 || j>=0){
            if(i>=0 && j>=0){
                if(a.charAt(i)=='1' && b.charAt(j)=='1'){
                    if(carry=='1'){
                        ans.append('1');
                        
                    }else{
                        ans.append('0');
                    }
                    carry='1';
                }else if(a.charAt(i)=='0' && b.charAt(j)=='0'){
                    if(carry=='1'){
                        ans.append( '1');
                        
                    }else{
                        ans.append('0');
                    }
                    carry='0';
                }else{
                    if(carry=='1'){
                        ans.append( '0');
                        carry='1';
                        
                    }else{
                        ans.append('1');
                        carry='0';
                    }
                   
                }
            }
            else if(i>=0){
                if(carry=='1' && a.charAt(i)=='1'){
                    ans.append( '0');
                    carry='1';
                    
                }else if(carry=='1' || a.charAt(i)=='1'){
                    ans.append( '1');
                    carry='0';
                }else{
                    ans.append( '0');
                    carry='0';
                }
            }else{
                if(carry=='1' && b.charAt(j)=='1'){
                    ans.append('0');
                    carry='1';
                    
                }else if(carry=='1' || b.charAt(j)=='1'){
                    ans.append('1');
                    carry='0';
                }else{
                    ans.append( '0');
                    carry='0';
                }
            }
            --i;--j;
        }
        if(carry=='1'){
            ans.append( '1');
        }
        return ans.reverse().toString();
    }
}