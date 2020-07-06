package code;

import java.util.Arrays;
import java.util.Scanner;

public class may1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String j=sc.nextLine();
        String s = sc.nextLine();
        System.out.println(SolveTheQuestion(j,s));
    }
    public static int SolveTheQuestion(String J, String S){
        char jarr[]= J.toCharArray();
        char sarr[] = S.toCharArray();
        int smallChar[]=new int[26];
        int capChar[]=new int[26];
        Arrays.fill(smallChar,0);
         Arrays.fill(capChar,0);

        for(int i=0;i<jarr.length;i++){
            if(jarr[i]>='a' && jarr[i]<='z'){
                smallChar[jarr[i]-97]=1;
            }else{
                capChar[jarr[i]-65]=1;
            }
        }
        int count=0;
        for(int i=0;i<sarr.length;i++){
            if(sarr[i]>='a' && sarr[i]<='z'){
                if(smallChar[sarr[i]-97]==1){
                    ++count;
                }
            }else{
                 if(capChar[sarr[i]-65]==1){
                    ++count;
                }
            }
        }
        return count;
    }
}