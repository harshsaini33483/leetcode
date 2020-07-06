package code;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstring {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str =sc.nextLine();
        System.out.println(lengthOfLongestSubstring(str));
        
    }   
    public static int lengthOfLongestSubstring(String s) {
       HashMap<Character, Integer> hsMap = new HashMap<>();
       int max = 0, j=0;
       for(int i=0;i<s.length();i++){
           if(hsMap.containsKey(s.charAt(i))){
            j=Math.max(j,hsMap.get(s.charAt(i)));
           }
           max =Math.max(max, i-j+1);
           hsMap.put(s.charAt(i), i+1);
       }

     
        return max;
    }
}