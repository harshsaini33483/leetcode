package code;

import java.util.Scanner;
import java.util.Stack;

public class may13 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        int k=sc.nextInt();
        System.out.println(removeKdigits(str, k));
    }

    public static String removeKdigits(String num, int k) {
        // StringBuilder str = new StringBuilder(num);
        // for(int i=0;i<k;i++){
        //     int j=1;
        //     while(j<str.length()){
        //         if(str.charAt(j-1)<=str.charAt(j)){
        //             ++j;
        //            continue;
        //         }
        //         break;
        //     }
        //     str.delete(j-1,j);
        // }
        // String finalStr ="";
        // int i=0;
        // for(;i<str.length();i++){
        //     if(str.charAt(i)=='0'){
        //         continue;
        //     }
        //     break;
        // }
        // for(;i<str.length();i++){
        //     finalStr+=str.charAt(i);
        // }
        // return finalStr.length()==0? "0": finalStr;


        Stack<Character> stack = new Stack<>();
        stack.push(num.charAt(0));
        int i=1;
        while(i<num.length()){
            if(!stack.isEmpty() && stack.peek()<=num.charAt(i)){
                stack.push(num.charAt(i));
            }else{
                while(!stack.isEmpty() && stack.peek()>num.charAt(i) && k>0){
                    stack.pop();
                    --k;
                }
                stack.push(num.charAt(i));
            }
            ++i;
        }
        while(k!=0){
            stack.pop();
            --k;
        }
        String intMedString = "";
        while(!stack.isEmpty()){
            intMedString=stack.pop()+intMedString;
        }
        String finalStr ="";
        i=0;
        for(;i<intMedString.length();i++){
            if(intMedString.charAt(i)=='0'){
                continue;
            }
            break;
        }
        for(;i<intMedString.length();i++){
            finalStr+=intMedString.charAt(i);
        }
        return finalStr.length()==0? "0": finalStr;

        
    }
    

}