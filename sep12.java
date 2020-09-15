package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class sep12 {
    static List<List<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k =sc.nextInt();
        int n =sc.nextInt();
        combinationSum3(k, n);
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        if(n==0){
            return ans;
        }   
        traverseN(k, n,1, new Stack<>());
        System.out.println(ans);
        return ans;
    }
    public static void traverseN(int k, int n,int start, Stack<Integer> currentArr){
        if(currentArr.size()==k){
            if(n==0){
                ans.add(new ArrayList(currentArr));
            }
            return;
        }
        for(int i=start;i<=9;i++){
            currentArr.add(i);
            traverseN(k, n-i,i+1, currentArr);
            currentArr.pop();
        }
    }
}
