package code;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class aug27 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int  n =sc.nextInt();
        int intervals[][]=new int[n][2];
        for(int i=0;i<n;i++){
            intervals[i][0]=sc.nextInt();
            intervals[i][1]=sc.nextInt();
        }
        findRightInterval(intervals);
    
    }
    public static int[] findRightInterval(int[][] intervals) {
        IntervalClass intervalClass[]=new IntervalClass[intervals.length];
        for(int i = 0;i<intervals.length;i++){
            intervalClass[i]=new IntervalClass(intervals[i][0], intervals[i][1], i);
        }
        Arrays.sort(intervalClass, new Comparator<IntervalClass>(){
            public int compare(IntervalClass a,  IntervalClass b){
                return a.start - b.start;
            }
        });
        int n = intervals.length;
        int ans []=new int[n];
        for(int i=0;i<intervals.length;i++){
            ans[intervalClass[i].index]=binarySearch(intervalClass, intervalClass[i].end, i, n);
        }
        return ans;
    }

    public static int binarySearch(IntervalClass []intervals, int value, int s, int e){
        int start = s;
        int end = e-1;
        int ans = -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(intervals[mid].start>=value){
               ans = intervals[mid].index;
               end =mid-1;
            }else{
                start= mid+1;
            }
        }
      
        return ans;
    }
    public int [] findAnotherSolution(int [][] intervals){
        int min = intervals[0][0];
        int max = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] < min) min = intervals[i][0];
            if(intervals[i][1] > max) max = intervals[i][1];
        }
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, -1);
        for (int i = 0; i < intervals.length; i++) {
            bucket[intervals[i][0] - min] = i;
        }
        for (int i = bucket.length - 2; i >= 0; i--) {
            if(bucket[i] == - 1) bucket[i] = bucket[i + 1];
        }
        int[] result = new int[intervals.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = bucket[intervals[i][1] - min];
        }
        return result;
    }
}
class IntervalClass{
    int start;
    int end;
    int index;
    public IntervalClass(int start, int end, int index){
        this.start= start;
        this.end = end;
        this.index =index;

    }
}