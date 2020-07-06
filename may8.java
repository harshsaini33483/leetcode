package code;

import java.util.*;

public class may8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        int slope = calculateSlope(arr);
        int b =calculateB(arr, slope);
        System.out.println(checkStraightLine(arr, slope, b));
    }
    public static int calculateSlope(int arr[][]){
        if((arr[1][0]-arr[0][0])==0){
            return 0;
        }
        return (arr[1][1]-arr[0][1])/(arr[1][0]-arr[0][0]);
    }
    public static int calculateB(int arr[][], int slope){
        return (slope*arr[0][0])-arr[0][1];
    }
    public static boolean checkStraightLine(int arr[][],int slope, int b){
        for(int i=0;i<arr.length;i++){
            int sol = (slope*arr[i][0])-b;
            if(arr[i][1]!=sol){
                return false;
            }
        }
        return true;
    }
}


// y =slope(x)-b;
// y+b =slope(x);
// b = slope(x)-y;