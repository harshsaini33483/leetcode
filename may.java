package code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class may {

    
        public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String n=sc.nextLine();
        IndexSolution arr []=new IndexSolution[26];
        for(int i=0;i<26;i++){
            arr[i]=new IndexSolution();
        }
        for(int i=0;i<n.length();i++){
            char c = n.charAt(i);
            ++arr[c-97].count;
            arr[c-97].lastPos = i;
        }
        int min =0;
        for(int i=0;i<26;i++){
            if(arr[i].count==1){
                if(arr[i].lastPos<min){
                    min= arr[i].lastPos;
                }
                System.out.println( arr[i].lastPos);
            }
        }
        System.out.println(-1);
    }
}
 class IndexSolution{
    public int count;
    public int lastPos;
}