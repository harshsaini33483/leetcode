package code;

import java.util.Scanner;

public class aug8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        final TreeNode treeNode = new TreeNode(sc.nextInt());
        treeNode.left = new TreeNode(sc.nextInt());
        treeNode.right = new TreeNode(sc.nextInt());
       // treeNode.left.left = new TreeNode(sc.nextInt());
        // treeNode.left.right = new TreeNode(sc.nextInt());
        treeNode.right.left = new TreeNode(sc.nextInt());
        treeNode.right.right = new TreeNode(sc.nextInt());
    }
    public static int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        return pathSum(root.left, sum)+ pathUtil(root, sum)+ pathSum(root.right, sum);
    }

    public static int pathUtil(TreeNode root,int res){
        if(root==null){
            return 0;
        }
        int sum = 0;
        if(root.val==res){
            ++sum;
        }
        sum+=pathUtil(root.left, res-root.val);
        sum+=pathUtil(root.right, res-root.val);
        return sum;
    }
}