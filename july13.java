package code;

import java.util.Scanner;

public class july13 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        final TreeNode treeNode1 = new TreeNode(sc.nextInt());
        // treeNode1.left = new TreeNode(sc.nextInt());
        // treeNode1.right = new TreeNode(sc.nextInt());
        // // treeNode1.left.left = new TreeNode(sc.nextInt());
        // // treeNode1.left.right = new TreeNode(sc.nextInt());
        // treeNode1.right.left = new TreeNode(sc.nextInt());
        // treeNode1.right.right = new TreeNode(sc.nextInt());
        // treeNode1.left = new TreeNode(sc.nextInt());
        // treeNode1.left = new TreeNode(sc.nextInt());

        final TreeNode treeNode2 = new TreeNode(sc.nextInt());
        // treeNode2.left = new TreeNode(sc.nextInt());
        // treeNode2.right = new TreeNode(sc.nextInt());
        // // treeNode2.left.left = new TreeNode(sc.nextInt());
        // // treeNode2.left.right = new TreeNode(sc.nextInt());
        // treeNode2.right.left = new TreeNode(sc.nextInt());
        // treeNode2.right.right = new TreeNode(sc.nextInt());
        // treeNode2.left = new TreeNode(sc.nextInt());
        // treeNode2.left = new TreeNode(sc.nextInt());
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
     
        return dfs(p,q);
    }
    public static boolean dfs(TreeNode tree1, TreeNode tree2){
        if(tree1==null && tree2==null){
            return true;
        }else if(tree1==null && tree2!=null){
            return false;
        }else if(tree1!=null && tree2==null){
            return false;
        }else if(tree1.val!=tree2.val){
            return false;
        }
        
        if(!dfs(tree1.left, tree2.left)){
            return false;
        }
        if(!dfs(tree1.right, tree2.right)){
            return false
        }
 
    }
}