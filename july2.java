package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class july2 {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final TreeNode treeNode = new TreeNode(sc.nextInt());
        treeNode.left = new TreeNode(sc.nextInt());
        treeNode.right = new TreeNode(sc.nextInt());
        treeNode.left.left = new TreeNode(sc.nextInt());
        // treeNode.left.right = new TreeNode(sc.nextInt());
        treeNode.right.left = new TreeNode(sc.nextInt());
        treeNode.right.right = new TreeNode(sc.nextInt());
        // treeNode.left = new TreeNode(sc.nextInt());
        // treeNode.left = new TreeNode(sc.nextInt());
        /*
         * 6 / \ 3 7 / \ / 2 4 10
         * 
         * ans 6 / \ 7 3 \ / \ 10 4 2
         * 
         */
        levelOrderBottom(treeNode);
        sc.close();
    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null){
            return new ArrayList<List<Integer>>();
        }
        //List<List<Integer>> ans= bfs(root);
        List<List<Integer>> ans= new ArrayList<List<Integer>>();
        dfs(root,0,ans) ;
        return ans;
    }
    public static  List<List<Integer>> bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueLevel = new LinkedList<>();
        HashMap<Integer,List<Integer>> hSet =new HashMap<>();
        queue.add(root);
        queueLevel.add(0);

        List<List<Integer>> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            Integer tempLevel = queueLevel.poll();
            if(temp.left!=null){
                queue.add(temp.left);
                queueLevel.add(tempLevel+1);
            }
            if(temp.right!=null){
                queue.add(temp.right);
                queueLevel.add(tempLevel+1);
            }
            if(hSet.containsKey(tempLevel)){
                List<Integer> list = hSet.get(tempLevel);
                list.add(temp.val);
            }else{
                List<Integer> tempList = new ArrayList<>();
                tempList.add(temp.val);
                hSet.put(tempLevel, tempList);
            }
        }
        int size = hSet.size();
        for(int i=size-1;i>=0;i--){
            ans.add(hSet.get(i));
        }
        return ans;
    }

    public static void dfs(TreeNode root , int depth, List<List<Integer>>  ans){
        if(root==null){
            return ;
        }
        // New Depth found
        if(ans.size()==depth){
            ans.add(0,new ArrayList<Integer>());
        }
        ans.get(ans.size()-depth-1).add(root.val);
        dfs(root.left, depth + 1, ans);
        dfs(root.right, depth + 1, ans);
    }
}    