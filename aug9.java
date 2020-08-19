package code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class aug9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int grid[][]=new int[sc.nextInt()][sc.nextInt()];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        System.out.println(orangesRotting(grid));
    
    }
    public static int orangesRotting(int[][] grid) {
        Queue<Point> queue= new LinkedList<>();
        int freshQrange = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    queue.add(new Point(i,j));
                }else if(grid[i][j]==1){
                    ++freshQrange;
                }
            }
        }
        if(freshQrange==0){
            return 0;
        }
        if(queue.size()==0){
            return -1;
        }

        int ans = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean found=false;
            for(int i=0;i<size;i++){
                Point tempPoint = queue.poll();
                if(tempPoint.x-1>=0 && grid[tempPoint.x-1][tempPoint.y]==1){
                    found =true;
                    queue.add(new Point(tempPoint.x-1,tempPoint.y));
                    grid[tempPoint.x-1][tempPoint.y]=2;
                    --freshQrange;
                }
                if(tempPoint.x+1<grid.length && grid[tempPoint.x+1][tempPoint.y]==1){
                    found =true;
                    queue.add(new Point(tempPoint.x+1,tempPoint.y));
                    --freshQrange;
                    grid[tempPoint.x+1][tempPoint.y]=2;
                }
                if(tempPoint.y-1>=0 && grid[tempPoint.x][tempPoint.y-1]==1){
                    found =true;
                    queue.add(new Point(tempPoint.x,tempPoint.y-1));
                    --freshQrange;
                    grid[tempPoint.x][tempPoint.y-1]=2;
                }
                if(tempPoint.y+1<grid[tempPoint.x].length && grid[tempPoint.x][tempPoint.y+1]==1){
                    found =true;
                    queue.add(new Point(tempPoint.x,tempPoint.y+1));
                    --freshQrange;
                    grid[tempPoint.x][tempPoint.y+1]=2;
                }

            }
            if(found){
                ++ans;
            }
        }
        if(freshQrange!=0){
            return -1;
        }
        return ans;
    }
}
 class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}