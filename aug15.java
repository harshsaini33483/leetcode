package code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class aug15 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int intervals[][]=new int[sc.nextInt()][2];
        for(int i=0;i<intervals.length;i++){
            intervals[i][0]=sc.nextInt();
            intervals[i][1]=sc.nextInt();
        }
        System.out.println(eraseOverlapIntervals(intervals));

    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        // Interval interDiff[]=new Interval[intervals.length];
        // for(int i=0;i<intervals.length;i++){
        //     interDiff[i]=new Interval(intervals[i][0], intervals[i][1], intervals[i][0]-intervals[i][1]);
        // }
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] e1, int[]e2){
                if(e1[0]!=e2[0]){
                    return e1[0]-e2[0];
                }else{
                    return e1[1]-e2[1];
                }
            }
        });
        int end = intervals[0][1];
        int min = 0;
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                end = Math.min(end, intervals[i][1]);
                min++;
            } else {
                end = intervals[i][1];
            }
        }
        
        return min;
     }
}
class Interval{
    int start;
    int end;
    int diff;
    public Interval(int start, int end, int diff){
        this.start=start;
        this.end= end;
        this.diff=diff;
    }
}