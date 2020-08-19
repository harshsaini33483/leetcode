package code;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class aug18 {
    static Set<Integer> ans =new LinkedHashSet<>();

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        int k =sc.nextInt();
        numsSameConsecDiff(n, k);
      
    }
    public static int[] numsSameConsecDiff(int N, int K) {
        int i=1;
        if(K==0 || N==1){
            ans.add(0);
        }
        for(;i<=9;i++){
            createNumber(i, i, N, K, N-1);
        }
        int arr[]=new int[ans.size()];
        i=0;
        for(int j:ans){
            arr[i++]=j;
        }
        return arr;
    }
    public static void createNumber(int currNum, int lastAdded, int N, int K, int count){
        if (count == 0) {
            ans.add(currNum);
            return;
        } 
            int minusK = lastAdded - K;
            int plusK = lastAdded + K;
            int newCurrNum = currNum * 10;
            
            if (minusK >= 0) {
                createNumber(newCurrNum + minusK, minusK, N, K ,count-1);
            }
            
            if (plusK < 10) {
                createNumber(newCurrNum + plusK, plusK, N, K ,count-1);
            }
        
    }
}

/*
    10
        101
            1010
            1012


    12
        121 
            1210
            1212

        123
            1232
            1234
*/