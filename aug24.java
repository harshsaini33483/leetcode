package code;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class aug24 {
    static int sum=0;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        TreeNode treeNode=new TreeNode(sc.nextInt());
        treeNode.left = new TreeNode(sc.nextInt());
        treeNode.right = new TreeNode(sc.nextInt());
        treeNode.left.left = new TreeNode(sc.nextInt());
        treeNode.right.left = new TreeNode(sc.nextInt());
        treeNode.right.left.left = new TreeNode(sc.nextInt());

    }
    public static int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }
        Deque<MTreeNode> qDeque = new LinkedList<>();
        
        qDeque.add(new MTreeNode(0, root));
        int ans =0;
        while(!qDeque.isEmpty()){
            MTreeNode tempNode = qDeque.poll();
            if(tempNode.tree.left!=null){
                qDeque.add(new MTreeNode(1, tempNode.tree.left));
            }
            if(tempNode.tree.right!=null){
                qDeque.add(new MTreeNode(2, tempNode.tree.right));
            }
            if(tempNode.tree.left==null && tempNode.tree.right==null && tempNode.parent==1){
                ans+=tempNode.tree.val;
            }
        }
        return ans;
    }
    public static int anotherSolution(TreeNode root){
        if(root==null){
            return 0;
        }
        dfs(root);
        return sum;
    }
    public static TreeNode  dfs(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode  left =dfs(root.left);
        TreeNode right =dfs(root.right);
        if(left!=null && left.left==null && left.right==null){
            sum+=left.val;
        }
        return root;
    }
}

class MTreeNode{
    TreeNode tree;
    int parent;
    public MTreeNode(int parent, TreeNode tree){
        this.parent = parent;
        this.tree =tree;
    }
}