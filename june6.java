package code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class HeightClass {
    int first;
    int second;
    boolean isVisit;

    public HeightClass(int first, int second) {
        this.first = first;
        this.second = second;
        isVisit = false;
    }
}

class HeightSort implements Comparator<HeightClass> {
    public int compare(HeightClass a, HeightClass b) {
        if (a.first < b.first) {
            return 1;
        } else if (a.first > b.first) {
            return -1;
        } else {
            if (a.second > b.second) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}

public class june6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }
        reconstructQueue(array);
    }

    public static int[][] reconstructQueue(int[][] people) {
        HeightClass height[] = new HeightClass[people.length];
        for (int i = 0; i < people.length; i++) {
            height[i] = new HeightClass(people[i][0], people[i][1]);
        }
        Arrays.sort(height, new HeightSort());
        // if(height[start].isVisit){
        // ++start;
        // continue;
        // }
        for (int i = 1; i < height.length; i++) {
            if (height[i].second == 0) {
                continue;
            }
            int start = i ;
            int swapCount = height[i].second;
            for(int j=start+1;j<people.length;j++){
                if(height[i].first==height[j].first){
                    --swapCount;
                }else{
                    break;
                }
            }
            while (swapCount > 0 && start-1 >= 0) {
                HeightClass hi =height[start];
                height[start]=height[start-1];
                height[start-1]=hi;
                --start;
                --swapCount;
            }
        }
        int finalAns[][] = new int[people.length][2];

        for (int i = 0; i < people.length; i++) {
            finalAns[people.length-i-1][0] = height[i].first;
            finalAns[people.length-i-1][1] = height[i].second;
        }
        return finalAns;
    }
}