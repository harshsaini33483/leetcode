package code;

import java.util.Scanner;

public class june29 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int m =sc.nextInt();
        int n =sc.nextInt();
        System.out.println(uniquePaths(m, n));
    }
    public static int uniquePaths(int m, int n) {
        int array[][]=new int[n][m];
        for(int i=0;i<m;i++){
            array[0][i]=1;
        }
        for(int i=0;i<n;i++){
            array[i][0]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                array[i][j]=array[i][j-1]+array[i-1][j];
            }
        }
        return array[n-1][m-1];
    }
}