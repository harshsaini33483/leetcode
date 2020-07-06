package code;

import java.util.Scanner;

public class june26 {
     int  totalSum = 0;
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final TreeNode treeNode = new TreeNode(sc.nextInt());
        treeNode.left = new TreeNode(sc.nextInt());
        treeNode.right = new TreeNode(sc.nextInt());
        treeNode.left.left = new TreeNode(sc.nextInt());
        treeNode.left.right = new TreeNode(sc.nextInt());
        // treeNode.right.left = new TreeNode(sc.nextInt());
    //     treeNode.right.right = new TreeNode(sc.nextInt());
        // treeNode.left = new TreeNode(sc.nextInt());
        // treeNode.left = new TreeNode(sc.nextInt());
        june26 j=new june26();
        j.sumNumbers(treeNode);
       System.out.println(j.totalSum);
    }
    public  void sumNumbers(TreeNode root) {
        if(root==null){
            return ;
        }
         findNumber(root, new StringBuilder(Integer.toString(root.val)));
    }
    public  void findNumber(TreeNode node , StringBuilder sum){
        if(node.left==null && node.right==null){
            totalSum+=Integer.parseInt(sum.toString());
            sum.deleteCharAt(sum.length()-1);
            return;
        }
        if( node.right!=null){
            findNumber(node.right, sum.append(Integer.toString(node.right.val)));
            
        }

        if( node.left!=null){
            findNumber(node.left, sum.append(Integer.toString(node.left.val)));
          
        }
        sum.deleteCharAt(sum.length()-1);
    }
}