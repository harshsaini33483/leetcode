package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class may29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int array[][] = new int[k][2];
        for (int i = 0; i < k; i++) {
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }
        System.out.println(new may29().canFinish(n, array));
    }

    public  boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> hm =new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            if(hm.containsKey(prerequisites[i][1])){
                hm.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }else{
                HashSet<Integer> hs = new HashSet<>();
                hs.add(prerequisites[i][0]);
                hm.put(prerequisites[i][1],hs);
            }
        }
        int visited[]=new  int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!new may29().checkCycle(hm, visited, i)){
                return false;
            }
        }
      
       return true; 
    }
    public boolean checkCycle(HashMap<Integer, HashSet<Integer>> hMap, int[] visited, int node){
        if(visited[node]==-1){
            return false;
        }
        if(visited[node]==1){
            return true;
        }
        visited[node]=-1;
        if(hMap.containsKey(node)){
            for(int i : hMap.get(node)){
                if(!checkCycle(hMap, visited, i)){
                    return false;
                }
            }
        }
        visited[node]=1;
        return true;
    }
}

// 4
// [[2,0],[1,0],[3,1],[3,2],[1,3]]

// 4
// [[1,0],[2,0],[3,1],[3,2]]

// 8
// [[1,0],[2,6],[1,7],[6,4],[7,0],[0,5]]

// 7
// [[1,0],[0,3],[0,2],[3,2],[2,5],[4,5],[5,6],[2,4]]
/*
 * 7 8 1 0 0 3 0 2 3 2 2 5 4 5 5 6 2 4
 * 
 * 
 * 3 2 1 0 2 1 true
 * 
 * 4 5 2 0 1 0 3 1 3 2 1 3 false
 * 
 * 4 4 1 0 2 0 3 1 3 2
 * 
 * 
 * 8 6 1 0 2 6 1 7 6 4 7 0 0 5 true
 */
