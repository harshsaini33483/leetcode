package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class aug22 {
    static int total=0;
    static ArrayList<Integer> rec = new ArrayList<>();
    static int[][] rects;
    static Random random = new Random();

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int array[][]=new int[sc.nextInt()][4];
        for(int i=0;i<array.length;i++){
            array[i][0]=sc.nextInt();
            array[i][1]=sc.nextInt();
            array[i][2]=sc.nextInt();
            array[i][3]=sc.nextInt();
        }
        buildSolution(array);
        int  n=sc.nextInt();
        for(int i=0;i<n;i++){
            pick();
        }
    }
    public static void buildSolution(int [][]rect){
        total = 0;
        rects=rect;
        for (int[] r : rect) {
            total += (r[3] - r[1] + 1) * (r[2] - r[0] + 1);
            rec.add(total);
        }
    }
    public static int[] pick(){
        int next = random.nextInt(total);
        int index = Collections.binarySearch(rec,next);
        if(index<0){
            index=index*-1;
        }

        int hi = rects[index][3] - rects[index][1] + 1;
        int wid = rects[index][2] - rects[index][0] + 1;
        int low = rec.get(index) - wid * hi;
        int order = next - low;
        
       return new int[]{rects[index][0] + order / hi,rects[index][1] + order % hi };        
    }
}
class RectPoints{
    int x1;
    int x2;
    int y1;
    int y2;
    public RectPoints(int x1,int y1,int x2,int y2){
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
    }
}