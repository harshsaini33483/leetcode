package code;

import java.util.Scanner;

public class may28 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        countBits(n);
    }
    public static int[] countBits(int num) {
        int finalArr[]=new int[num+1];
        if(num==1){
            return new int[]{0,1};
        }
        if(num==2){
            return new int[]{0,1,1};
        }
        if(num==3){
            return new int[]{0,1,1,2};
        }

        int nextOne = 4;
        int countS = 0;
        int countN = 0;
        boolean lastWas = true;
        finalArr[0]=0;
        finalArr[1]=1;
        finalArr[2]=1;
        finalArr[3]=2;

        for(int i=4;i<=num;i++){
            if(i==nextOne){
                finalArr[i]=1;
                nextOne = nextOne*2;
                lastWas=true;
                countN = 0;
            }else if(i%2!=0){
                finalArr[i]=finalArr[i-1]+1;
            }else{
                if(lastWas){
                    finalArr[i]=finalArr[i-1];
                    lastWas=false;
                }else{
                    if(countN==0){
                        finalArr[i]=finalArr[i-1]-1;
                        ++countN;
                    }else{
                        finalArr[i]=finalArr[(i/2)];
                        countN=0;
                    }
                    lastWas=true;
                }
            }
        }
        return finalArr;

    }
}