package code;

import java.util.ArrayList;
import java.util.Scanner;

public class june20 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        int k = sc.nextInt();
        System.out.println(getPermutation(n, k));
    }
    public static String getPermutation(int n, int k) {
        if(n==1){
            return "1";
        }
        int num = 1;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i<=n;i++){
            num=num*i;
            arr.add(i);           
        }
        StringBuilder str =new StringBuilder();
        --k;
        for(int i=0;i<n;i++){
            num = num/(n-i);
            str.append(arr.remove(k/num));
            k=k%num;
        }
      return str.toString();
    } 

}