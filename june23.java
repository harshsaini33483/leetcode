package code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class june23 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        final TreeNode treeNode = new TreeNode(sc.nextInt());
        treeNode.left = new TreeNode(sc.nextInt());
         treeNode.right = new TreeNode(sc.nextInt());
         treeNode.left.left = new TreeNode(sc.nextInt());
         treeNode.left.right = new TreeNode(sc.nextInt());
         treeNode.right.left = new TreeNode(sc.nextInt());
         // treeNode.left = new TreeNode(sc.nextInt());
         // treeNode.left = new TreeNode(sc.nextInt());
         // treeNode.left = new TreeNode(sc.nextInt());
         System.out.println(countNodes(treeNode));
    }
    public static int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int count=0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            ++count;
            if(temp.left!=null){
                queue.add(temp.left);
            }if(temp.right!=null){
                queue.add(temp.right);
            }
        }
        return count;
    }
}