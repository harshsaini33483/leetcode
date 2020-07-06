package code;

import java.util.Scanner;

public class MaximumDepthofTree {
 static int depth=0;
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final TreeNode treeNode = new TreeNode(sc.nextInt());
        // treeNode.left = new TreeNode(sc.nextInt());
        // treeNode.right = new TreeNode(sc.nextInt());
        // // treeNode.left.left = new TreeNode(sc.nextInt());
        // // treeNode.left.right = new TreeNode(sc.nextInt());
        // treeNode.right.left = new TreeNode(sc.nextInt());
        // treeNode.right.right = new TreeNode(sc.nextInt());
        // treeNode.left = new TreeNode(sc.nextInt());
        // treeNode.left = new TreeNode(sc.nextInt());
        maxDepth(treeNode);
        System.out.println(depth);
        sc.close();

    }
    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root, 1);
        return depth;
    }
    public static void dfs(TreeNode root, int levelDepth){
        if(root==null){
            return ;
        }
        if(depth<levelDepth){
            depth =levelDepth;
        }
        dfs(root.left,levelDepth+1);
        dfs(root.right,levelDepth+1);
    }
}