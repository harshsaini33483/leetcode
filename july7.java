package code;
import java.util.Scanner;

public class july7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int grid[][]=new int[sc.nextInt()][sc.nextInt()];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        System.out.println(islandPerimeter(grid));
    }
    public static  int islandPerimeter(int[][] grid) {
        int ans =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                   ans+=checkSide(grid, i, j); 
                }
            }
        }
        return ans;
    }
    public static int checkSide(int [][]grid, int i, int j){
        int currAns=0;
        //left;
        if(j==0 ){
            ++currAns;
        }
        else if(j-1>=0 && grid[i][j-1]!=1){
            ++currAns;
        }
        //right
        if(j==grid[0].length-1){
            ++currAns;
        }
        else if(j+1<grid[0].length && grid[i][j+1]!=1){
            ++currAns;
        }
        //top

        if(i==0){
            ++currAns;
        }
        else if(i-1>=0 && grid[i-1][j]!=1){
            ++currAns;
        }
        //bottom
       if(i==grid.length-1){
            ++currAns;
       }else if(i+1<grid.length && grid[i+1][j]!=1){
           ++currAns;
       }
       return currAns;
    }
}