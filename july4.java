package code;

import java.util.ArrayList;
import java.util.Scanner;


public class july4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(nthUglyNumber(n));

    }

    public static int nthUglyNumber(int n) {
        if(n<7){
            return n;
        }
       ArrayList<Integer> arr =new ArrayList<>();
       arr.add(1);
       int twoInd =0;
       int threeInd=0;
       int fiveInd =0;
        for(int i=2;i<=n;i++){
            int two = arr.get(twoInd)*2;
            int three = arr.get(threeInd)*3;
            int five = arr.get(fiveInd)*5;
            int curr = Math.min(Math.min(two,three),five);
            arr.add(curr);
            if (curr == two) twoInd++;
            if (curr == three) threeInd++;
            if (curr == five) fiveInd++;
        }
        return arr.get(n-1);
    }
}