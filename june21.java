package code;

import java.util.Scanner;

public class june21 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int rowArr[][]=new int [r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                rowArr[i][j]=sc.nextInt();
            }
        }
        calculateMinimumHP(rowArr);
    }
    public static int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int arr[][]=new int[row][col];
        arr[row-1][col-1] = dungeon[row-1][col-1]>0 ? 1 : 1- dungeon[row-1][col-1];
        for(int i=row-2;i>=0;i--){
            arr[i][col-1] =  Math.max(dungeon[i][col-1]-arr[i+1][col-1],1);
        }
        for(int i=col-2;i>=0;i--){
            arr[i][row-1] =  Math.max(dungeon[i][row-1]-arr[i+1][row-1],1);
        }
        for(int i=row-2;i>=0;i--){
            for(int j=col-2;j>=0;j--){
                arr[i][j]=Math.max(Math.min(arr[i+1][j],arr[i][j+1])-dungeon[i][j],1);
            }
        }
        return arr[0][0];
    }
}