package code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ClimbingLeaderBoard {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int scores[]=new int[n];
        for(int i=0;i<n;i++){
            scores[i]=sc.nextInt();
        }
        int m=sc.nextInt();
        int alice[]=new int[m];
        for(int i=0;i<m;i++){
            alice[i]=sc.nextInt();
        }
        System.out.println(climbingLeaderboard(scores, alice));
    }
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
       int finalAns []=new int[alice.length];
        HashSet<Integer>hs=new HashSet<Integer>();
        for(int i:scores){
            hs.add(i);
        }
        Integer newScore[]=hs.toArray(new Integer[hs.size()]);
        Arrays.sort(newScore);
        int len = newScore.length;
        int j=0;
        for(int i=0;i<alice.length;i++){
            int num = Arrays.binarySearch(newScore, alice[i]);
            if(num<0){
                 num = (num*-1)-1;
            }
            else if(newScore[num]==alice[i]){
                ++num;
            }
            finalAns[j++]=len-num+1;
        }
        return finalAns; 
    }
}