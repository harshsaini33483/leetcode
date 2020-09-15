package code;

import java.util.Scanner;

public class sep8 {
    static int sum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final TreeNode treeNode1 = new TreeNode(sc.nextInt());
        treeNode1.left = new TreeNode(sc.nextInt());
        treeNode1.right = new TreeNode(sc.nextInt());
        treeNode1.left.left = new TreeNode(sc.nextInt());
        treeNode1.left.right = new TreeNode(sc.nextInt());
        treeNode1.right.left = new TreeNode(sc.nextInt());
        treeNode1.right.right = new TreeNode(sc.nextInt());
//         0
//       /   \
//      1      1
//    /  \    /  \
//   0    0  1    1    
// 010 + 010 + 011+ 011 = 2+2+3+3=10
       System.out.println(sumRootToLeaf(treeNode1));
    }
    public static int sumRootToLeaf(TreeNode root) {
        if(root==null){
            return sum;
        }
        if(root.left==null && root.right==null){
            return root.val;
        }
        dfs(root, new StringBuffer());
        return sum;
    }
    public static void dfs(TreeNode node, StringBuffer currSum){
        if(node==null){
            return;
        }
        if(node.left==null && node.right==null){
            sum+=Integer.parseInt(currSum.append(node.val).toString(),2);
            return;
        }
      
        dfs(node.left,new StringBuffer(currSum.toString()+node.val));
        dfs(node.right, new StringBuffer(currSum.toString()+node.val));
    }
}
