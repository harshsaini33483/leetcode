package code;

import java.util.Scanner;


// Real Life example is autocorrect
// https://www.youtube.com/watch?v=OCsF6u-bLBc
// https://www.youtube.com/watch?v=XJ6e4BQYJ24
// https://www.youtube.com/watch?v=We3YDTzNXEk
public class may31 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(minDistance(str1, str2));
        
    }
    public static int minDistance(String word1, String word2) {
        int ans =0;
        int dp [][]=new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word2.length();i++){
            dp[0][i]=i;
        }
        for(int i=0;i<=word1.length();i++){
            dp[i][0]=i;
        }
        /*  r   o   s
         0   1   2   3
       h 1
       o 2
       r 3
       s 4
       e 5
        */
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    int firstMin =Math.min(dp[i-1][j-1],dp[i][j-1]);
                    dp[i][j]= Math.min(firstMin, dp[i-1][j])+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}