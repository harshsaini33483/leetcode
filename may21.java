package code;

import java.util.Scanner;

public class may21 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int array[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                array[i][j]=sc.nextInt();
            }
        }
        System.out.println(countSquares(array));

    }
    public static int countSquares(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int array[][]=new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0){
                    array[0][j]=matrix[0][j];
                }else if(j==0){
                    array[i][0]=matrix[i][0];
                }
                else{
                    if(matrix[i][j]==1){
                        int top = Math.min(array[i-1][j], array[i-1][j-1]);
                        int side = Math.min(top, array[i][j-1]);
                        array[i][j]=side+1;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                count+=array[i][j];
            }
        }
        return count;
    }
}