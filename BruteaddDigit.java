package code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BruteaddDigit {
    static HashMap<Long,Long> hs=new LinkedHashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        // for(long i=10;i<n;i++){
        //     int count = BruteForce(i);
        //     // System.out.println("//////////////////////////////");
        //     // System.out.println(count+"     "+i);
        //     if(count==3){
        //         //System.out.println("....................................");
        //         // System.out.println(count+"    "+i);
                
        //         //System.out.println("....................................");
        //     }
        //     // System.out.println("//////////////////////////////");
        
        // }
        // for(Map.Entry<Long, Long> map : hs.entrySet()){
        //     System.out.print(map.getKey()+", ");
        // }
        System.out.println(BruteForce(n));
    }

    public static int BruteForce(Long num){
        int count=0;
        long myNum  = num;
        long first =0;
        boolean firstNum=false;
        while(num>9){
            long no=0L;
            while(num!=0){
                long lastDigit = num%10;
                no+=lastDigit;
                num=num/10;
            }
            if(!firstNum){
                firstNum = true;
                first=no;
            }
      //     System.out.println(no);
            ++count;
            num = no;
        }
        if(count==2){
            hs.put(first, myNum);
        }
        return count;
    }
}