package code;

import java.util.ArrayList;
import java.util.Scanner;

public class may23 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        int m=sc.nextInt();
        int array1[][]=new int[n][2];
        int array2[][]=new int[m][2];
        for(int i=0;i<n;i++){
            array1[i][0]=sc.nextInt();
            array1[i][1]=sc.nextInt();
        }
        for(int i=0;i<m;i++){
            array2[i][0]=sc.nextInt();
            array2[i][1]=sc.nextInt();
        }
        intervalIntersection(array1, array2);
    }
    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<IndexSol> arr =new ArrayList<>();
        int i=0,aIndex = 0, bIndex=0;
        int lenA = A.length;
        int lenB = B.length;
        while(aIndex<lenA && bIndex<lenB){
            int max = Math.max(A[aIndex][0],B[bIndex][0]);
            int min  =  Math.min(A[aIndex][1], B[bIndex][1]);
            if(min>=max){
                IndexSol currAns= new IndexSol();
                currAns.start = max;
                currAns.end = min;
                arr.add(currAns);
            }
           
            if(A[aIndex][1]<B[bIndex][1]){
                ++aIndex;
            }else if(A[aIndex][1]>B[bIndex][1]){
                ++bIndex;
            }else{
                ++bIndex;
                ++aIndex;
            }

        }
        i=0;
        int ans [][]=new int [arr.size()][2];

        for(IndexSol temp: arr){
            ans[i][0]=temp.start;
            ans[i][1]=temp.end;
            ++i;
        }
        return ans;
    }
}
//[[0,2],[5,10],[13,23],[24,25]], 
//B = [[1,5],[8,12],[15,24],[25,26]]
//[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
class IndexSol{
    int start;
    int end;
}