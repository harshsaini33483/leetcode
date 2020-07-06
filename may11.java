package code;

import java.util.Scanner;

public class may11 {
    public static void main(String[] args) {
        Scanner so=new Scanner(System.in);
        int n=so.nextInt();
        int m=so.nextInt();
        int array[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                array[i][j]=so.nextInt();
            }
        }
        int sr=so.nextInt();
        int sc=so.nextInt();
        int newColor = so.nextInt();
       int output[][]= floodFill(array, sr,sc, newColor);
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
           System.out.print(output[i][j]);
        }
        System.out.println();
    }
    }
    //[[1,1,1],[1,1,0],[1,0,1]]
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       // System.out.println(sr+"    "+sc+"  "+newColor);
        int currentColor = image[sr][sc];
         recursiveFlood(image, newColor, currentColor, sr,sc);
         return image;
    }
    public static void recursiveFlood(int ima[][], int newColor, int currentColor,int x, int y){
     //   System.out.println(x+"   "+y+" "+ima.length+"  "+ima[0].length+"  "+newColor+" "+currentColor);
        if(x<0 || x>=ima.length || y<0 || y>=ima[0].length){
            System.out.println("hello "+x+"   "+y);
            return ;
        }
        System.out.println(ima[x][y]+"   color "+ currentColor+"  "+x+"   "+y);

        if(ima[x][y]==currentColor && ima[x][y]!=newColor){
            ima[x][y]=newColor;
            recursiveFlood(ima, newColor, currentColor, x-1, y);
            recursiveFlood(ima, newColor, currentColor, x, y-1);
            recursiveFlood(ima, newColor, currentColor, x+1, y);
            recursiveFlood(ima, newColor, currentColor, x, y+1);
        }
    }
}