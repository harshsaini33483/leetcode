package code;

import java.util.ArrayList;
import java.util.List;

public class july24 {
    static ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static void main(final String[] args) {
        int graph[][] = new int[5][];
        graph[0] = new int[3];
        graph[1] = new int[3];
        graph[2] = new int[1];
        graph[3] = new int[1];
        graph[0][0] = 4;
        graph[0][1] = 3;
        graph[0][2] = 1;

        graph[1][0] = 3;
        graph[1][1] = 2;
        graph[1][2] = 4;

        graph[2][0] = 3;
        graph[3][0] = 4;
        allPathsSourceTarget(graph);

    }

    public static List<List<Integer>> allPathsSourceTarget(final int[][] graph) {
        if (graph.length == 0 || graph[0].length == 0) {
            return new ArrayList<List<Integer>>();
        }
        boolean visited[] = new boolean[graph.length];
        visited[0] = true;
        for (int i : graph[0]) {
            ArrayList<Integer> tempAns = new ArrayList<Integer>();
            tempAns.add(0);
            dfs(graph, i, graph.length - 1, visited, tempAns);
        }
        return ans;
    }

    public static void dfs(int graph[][], int currNode, int des, boolean visited[], ArrayList<Integer> tempAns) {
        ArrayList<Integer> intMet = new ArrayList<>(tempAns);
        if (currNode == des) {
            intMet.add(des);
            ans.add(intMet);
            return;
        }
        if (visited[currNode]) {
            return;
        }
        visited[currNode] = true;
        tempAns.add(currNode);
        for (int i : graph[currNode]) {
            dfs(graph, i, des, visited, tempAns);
        }
        visited[currNode] = false;
    }
}

// int graph[][]=new int[5][];
// graph[0]=new int[3];
// graph[1]=new int[3];
// graph[2]=new int[1];
// graph[3]=new int[1];
// graph[0][0]=4;
// graph[0][1]=3;
// graph[0][2]=1;

// graph[1][0]=3;
// graph[1][1]=2;
// graph[1][2]=4;

// graph[2][0]=3;
// graph[3][0]=4;