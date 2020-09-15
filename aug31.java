package code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class aug31 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        final TreeNode treeNode = new TreeNode(sc.nextInt());
        treeNode.left = new TreeNode(sc.nextInt());
        treeNode.right = new TreeNode(sc.nextInt()); 
       treeNode.left.left = new TreeNode(sc.nextInt());
        treeNode.left.right = new TreeNode(sc.nextInt());
      //  treeNode.right.left = new TreeNode(sc.nextInt());
        treeNode.right.right = new TreeNode(sc.nextInt());
        TreeNode tree= deleteNode(treeNode, sc.nextInt());
        System.out.println(tree);
    }
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return root;
        }
        if(root.val==key){
          return manipulateNode(root);
        }
        TreeNode newRoot =root;
        Queue<TreeNode> bfs =new LinkedList<>();
        bfs.add(newRoot);
        while(!bfs.isEmpty()){
            TreeNode tempNode = bfs.poll();
            if(tempNode.left!=null){
                if(tempNode.left.val==key){
                    tempNode.left=manipulateNode(tempNode.left);
                    return root;
                }else{
                    bfs.add(tempNode.left);
                }
            }
            if(tempNode.right!=null){
                if(tempNode.right.val==key){
                    tempNode.right=manipulateNode(tempNode.right);
                    return root;
                }else{
                    bfs.add(tempNode.right);
                }
            }
        }
        return root;
    }
    public static TreeNode manipulateNode(TreeNode root){
        if(root.left==null && root.right==null){
            return null;
        }
        if(root.left==null && root.right!=null ){
            return root.right;
        }

        else if(root.left!=null && root.right==null ){
            return root.left;
        }else{
            TreeNode leftnode = root.left;
            root = root.right;
            TreeNode travNode =root;
            while(travNode.left!=null){
                travNode = travNode.left;
            }
            travNode.left = leftnode;
            return root;
        }
    }
}