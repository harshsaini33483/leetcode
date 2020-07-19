package code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class july18 {
    static Stack<Integer>ans =new Stack<Integer>();
    static HashSet<Integer>visitSet = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int prerequisites[][] = new int[t][n];
        for(int i=0;i<t;i++){
            prerequisites[i][0]=sc.nextInt();
            prerequisites[i][1]=sc.nextInt();
        }
        findOrder(n, prerequisites);
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] dependancyCourse=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            dependancyCourse[i]=new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            dependancyCourse[prerequisites[i][1]].add(prerequisites[i][0]);
        }
       
        boolean visited[]=new boolean[numCourses];
        boolean done[]=new boolean[numCourses];
        int ansArr[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(dependancyCourse[i].size()!=0 && !visited[i]){
                if(!dfs(dependancyCourse, i, visited)){
                    return new int[0];
                }
            }
            
            // done[numCourses]=true;
          //  ans.add(prerequisites[i][1]);
        }
     
        Set<Integer>uniqueSet =new LinkedHashSet<Integer>();
        while(!ans.isEmpty()){
            System.out.println(ans.peek());
            uniqueSet.add(ans.pop());
        }
        int j=0;
        for(int i: uniqueSet){
           ansArr[j]=i;
           done[j]=true;
           ++j;
       }
       for(int i=0;i<numCourses;i++){
           if(!uniqueSet.contains(i)){
            ansArr[j]=i;
            ++j;
           }
       }
        return ansArr;
    }
    public static boolean dfs(ArrayList<Integer>[] depend, int current, boolean visited[]){
        if(visited[current]){
            return false;
        }
        if(visitSet.contains(current)){
            return true;
        }
        visited[current]=true;
        for(int i: depend[current]){
           if(!dfs(depend, i, visited)){
               return false;
           }
        }
        ans.push(current);
        visitSet.add(current);
        visited[current]=false;
        return true;
    }
}

//2
//[[0,1]]