package code;

import java.util.Scanner;

public class july12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int ans = reverseBits(n);
        System.out.println(ans);
        System.out.println(Integer.reverse(n));
    }
    public static int reverseBits(int n) {
          int reverseBit = 0;
        for(int i=0;i<31;i++){
            if((n&1)==1){
                reverseBit=reverseBit|1;   
            }
            reverseBit=reverseBit<<1;
            n=n>>1;

        }
        return reverseBit| (n&1);
    }
    public static int secondSol(int n){
        int reverseBit = 0;
        int times= 31;
        while(times>=0){
            int last = (n&1);
            if(last==1){
                reverseBit=reverseBit | last<<times;   
            }
            times--;
            n=n>>1;

        }
        return reverseBit;
    }
}
// 00000010100101000001111010011100
// 00111001011110000010100101000000
// 10111111111111111111111111111111