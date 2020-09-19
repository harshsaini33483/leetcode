package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class spe19 {
    static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sequentialDigits(sc.nextInt(), sc.nextInt());
        System.out.println();
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        // Bruteforce(low, high);
        String start = Integer.toString(low);
        String finasl = Integer.toString(high);
        int currentLen = start.length();

        int finalLen = finasl.length();
       
        for(int i=currentLen;i<=finalLen;i++){
            optimize(i, '1', low, high);
        }
        // betterWithoutRecursion(low,high)
        return ans;
    }
    public static void betterWithoutRecursion(int low, int high){
        for(int i=1;i<10;i++){
            int num=0, j =i;
            while(num<=high && j<10){
                 num = num*10+(j);
                if(num>=low && num<=high){
                    ans.add(num);
                }
                j++;
            }
        }
        Collections.sort(ans);
        
    }
    public static void optimize(int currentLen,  char currentNo, int startVal, int finalVal) {

        if (currentNo + currentLen-1  >57) {
            return;
        }
        StringBuilder generateNo = new StringBuilder();
        char tempchar = currentNo;
        for (int i = 0; i < currentLen; i++) {
            if (tempchar-(currentLen-i)<=57) {
                generateNo.append((char)(tempchar));
                ++tempchar;
            }else{
                return;
            }
        }
        int gen= Integer.parseInt(generateNo.toString());
        if(gen>=startVal && gen<=finalVal){
            ans.add(gen);
        }
        optimize(currentLen,(char) (currentNo+1), startVal, finalVal);
    }

    public static void Bruteforce(int low, int high) {
        // BruteForce
        for (int i = low; i <= high; i++) {
            String str = Integer.toString(i);
            boolean ok = true;
            for (int j = 1; j < str.length(); j++) {
                if (str.charAt(j) - str.charAt(j - 1) != 1) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                ans.add(i);
            }
        }
    }

}
