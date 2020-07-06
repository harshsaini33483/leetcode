package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class june5 {
    List<Integer> arr =new ArrayList<Integer>();
    Random random = new Random();

    int n=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int array[]=new int[n];
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        june5 j5 =new june5(array);
        int param_1 = j5.pickIndex();
    }

    public june5(int[] w) {
       n=w[0];
        arr.add(n);
        for(int i=1;i<w.length;i++){
            w[i]+=w[i-1];
            arr.add(w[i]);
            n=w[i];
        }
    }
    
    public int pickIndex() {
       return  Collections.binarySearch(arr, random.nextInt(n)+1);
    }
}