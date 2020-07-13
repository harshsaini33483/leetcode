package code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class july9 {
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
        widthOfBinaryTree(treeNode);
    }
    public static int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        LinkedList<QueueTree> que = new LinkedList<>();
        que.add(new QueueTree(root,0));
        int ans=0;
        while(!que.isEmpty()){
            int size = que.size();
            QueueTree start = que.getFirst();
            QueueTree end = que.getLast();
            ans = Math.max(ans, end.index-start.index+1);
            for(int i=0;i<size;i++){
                QueueTree tree = que.poll();
                if(tree.node.left!=null){
                    que.add(new QueueTree(tree.node.left, 2*tree.index+1));
                }
                if(tree.node.right!=null){
                    que.add(new QueueTree(tree.node.right, 2*tree.index+2));
                }
            }
        }
        return ans;
    }
}
class QueueTree{
    public TreeNode node;
    public int index;
    public QueueTree(TreeNode node, int index){
        this.node = node;
        this.index =index;
    }
}