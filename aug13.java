package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class aug13 {
    static ArrayList<String> arr = new ArrayList<>();
    static int pointer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();
        buildCombination(str, n);
        for(String temp : arr){
            System.out.println(temp.toString());
        }
    }

    private static void buildCombination(String str, int n) {
        int len = str.length();
        for (int i = 1; i < (1 << len); i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < len; j++) {
                if ((i & 1 << j) != 0) {
                    // append chars for set bit
                    s.append(str.charAt(j));
                }
            }
            if (s.length() == n) {
                arr.add(s.toString());
            }
        }     
           Collections.sort(arr);

    }
    public static String next() {
        
        return arr.get(pointer++).toString();

    }
    
    public static boolean hasNext() {
        if(arr.size()<pointer){
            return true;
        }
        return false;
    } 
}