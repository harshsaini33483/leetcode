package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sep13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intervals[][] = new int[sc.nextInt()][2];
        for (int i = 0; i < intervals.length; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        int newinterval[] = new int[2];
        newinterval[0] = sc.nextInt();
        newinterval[1] = sc.nextInt();
        int ans[][] = insert(intervals, newinterval);
        System.out.println(ans);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(newInterval.length==0){
            return intervals;
        }
        int n= intervals.length;
        int i = 0;
        List<Intervals> ans =new ArrayList<>();
        while(i<n && intervals[i][1]<newInterval[0]){ans.add(new Intervals(intervals[i][0],intervals[i][1])); ++i;}

        int mid[]=newInterval;
while(i<n && intervals[i][0]<=newInterval[1]){
    mid[0]=Math.min(mid[0], intervals[i][0]);
    mid[1]=Math.max(mid[1],intervals[i][1]);
    ++i;
}
ans.add(new Intervals(mid[0], mid[1]));

while(i<n ){ans.add(new Intervals(intervals[i][0],intervals[i][1]));}

        int arrans[][] = new int[ans.size()][2];
        for (  i = 0; i < ans.size(); i++) {
            arrans[i][0] = ans.get(i).start;
            arrans[i][1] = ans.get(i).end;
        }
        return arrans;
       
    }

}

class Intervals {
    int start;
    int end;

    public Intervals(int start, int end) {
        this.start = start;
        this.end = end;
    }
}