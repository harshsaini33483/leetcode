package code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class IndexValueClass{
    int index;
    double value;
    public IndexValueClass(int index, double value){
        this.index= index;
        this.value= value;
    }
}
class IndexValueSort implements Comparator<IndexValueClass>{
    public int compare(IndexValueClass a, IndexValueClass b){
        double value= (a.value-b.value);
        if(value>0){
            return 1;
        }else if(value<0){
            return -1;
        }
        return 0;
    }
}

public class may30 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k= sc.nextInt();
        int array[][]=new int[n][2];
        for(int i=0;i<n;i++){
            array[i][0]=sc.nextInt();
            array[i][1]=sc.nextInt();
        }
        System.out.println(new may30().kClosest(array,k));
    }
    public int[][] kClosest(int[][] points, int K) {
        IndexValueClass finalArr[]=new IndexValueClass[points.length];

        for(int i=0;i<points.length;i++){
            double squareFirst = Math.pow(points[i][1], 2);
            double sqaureSecond = Math.pow(points[i][0], 2);
            double tempAns=Double.MAX_VALUE;;
            if(squareFirst+sqaureSecond>=0){
                 tempAns = Math.sqrt(squareFirst+sqaureSecond);
            }
            finalArr[i]=new IndexValueClass(i, tempAns);
        }
        Arrays.sort(finalArr, new IndexValueSort());
        int finalAns[][]=new int[K][2];
        for(int i=0;i<K;i++){
            int index = finalArr[i].index;
            finalAns[i][0]=points[index][0];
            finalAns[i][1]=points[index][1];
        }
        return finalAns;
    }
}

// [[3,3],[5,-1],[-2,4]], K = 2
// [[1,3],[-2,2]], K = 1