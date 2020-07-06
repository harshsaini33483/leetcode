package code;

import java.util.Scanner;

public class june15 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeNode root =new TreeNode(sc.nextInt());
        root.left = new TreeNode(sc.nextInt());
        root.right = new TreeNode(sc.nextInt());
        root.left.left =new TreeNode(sc.nextInt());
        root.left.right = new TreeNode();

    }
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return root;
        } 
        if(root.val<val){
           return searchBST(root.right, val);
        }else if(root.val>val){
           return searchBST(root.left, val);
        }else{
            return root;
        }
    }
}