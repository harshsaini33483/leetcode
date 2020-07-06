package code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class ArrayIndex{
    int first,second;
    public ArrayIndex(int first, int second){
        this.first=first;
        this.second = second;
    }
}
class SortFirst implements Comparator<ArrayIndex>{
    public int compare(ArrayIndex a, ArrayIndex b){
        return a.first-a.second < b.first-b.second ? -1:1;
    }
}
public class june3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int array[][]=new int[sc.nextInt()][2];
        for(int i=0;i<array.length;i++){
            array[i][0]=sc.nextInt();
            array[i][1]=sc.nextInt();
        }
        System.out.println(twoCitySchedCost(array));
    }
    public static int twoCitySchedCost(int[][] costs) {
        ArrayIndex []arrA=new ArrayIndex[costs.length];

        for(int i=0;i<costs.length;i++){
            arrA[i]=new ArrayIndex(costs[i][0],costs[i][1]);
        }
        Arrays.sort(arrA, new SortFirst());

        int total=0;
        for(int i=0;i<costs.length/2;i++){
            total+=arrA[i].first;
        }
        for(int i=costs.length/2;i<costs.length;i++){
            total+=arrA[i].second;
        }
        return total;
    }
}