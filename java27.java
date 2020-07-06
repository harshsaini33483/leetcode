package code;

import java.util.ArrayList;
import java.util.Scanner;

public class java27 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        java27 june27 = new java27();
        System.out.println(june27.numSquares(n));
    }
    public int numSquares(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        ArrayList<Integer> tempArr = new ArrayList<Integer>();
        int till = (int)Math.sqrt(n)+3;
        if(till*till==n){
            return 1;
        }        
        // for(int i=1;i<=till;i++){
        //     tempArr.add(i*i);
        // }
        
        // int maxCount = Integer.MAX_VALUE;
        // for(int i=tempArr.size()-1;i>=0;i--){
        //     int currSum =0;
        //     int currCount=0;
        //     int j=i;
        //     while(currSum<n && j>=0){
        //         int no = tempArr.get(j);
        //         if(currSum+no==n){
        //             ++currCount;
        //             break;
        //         }if(currSum+no<n){
        //             ++currCount;
        //             currSum+=no;
        //             continue;
        //         }else{
        //             --j;
        //         }
        //     }
        //     if(maxCount>currCount){
        //         maxCount= currCount;
        //     }
        // }

        //42= 34+9
                // 34 = 25+9
        tempArr.add(0);
        for(int i=1;i<=n;i++){
            int min_val = i;
            int sq = 1, y=1;
            while(sq<=i){
                min_val = Math.min(min_val, 1+tempArr.get(i-sq));
                ++y;
                sq= y*y;
            }
            tempArr.add(i, min_val);
        }
        return tempArr.get(n);
    }
}