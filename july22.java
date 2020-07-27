package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class july22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(sc.nextInt());
        root.left = new TreeNode(sc.nextInt());
        root.right = new TreeNode(sc.nextInt());
        root.left.left = new TreeNode(sc.nextInt());
        //root.right.left = new TreeNode(sc.nextInt());
        root.right.right = new TreeNode(sc.nextInt());
        // root.left.left.left = new TreeNode(sc.nextInt());
        // root.right.right.left = new TreeNode(sc.nextInt());
        // root.right.right.right = new TreeNode(sc.nextInt());
        // root.left.left.left.right = new TreeNode(sc.nextInt());
        // root.right.right.right = new TreeNode(sc.nextInt());

        // 1
        // / \
        // 2 3
        // / \
        // 4 5

        zigzagLevelOrder(root);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();

        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> depth = new LinkedList<>();
        nodes.add(root);
        depth.add(0);
        while (!nodes.isEmpty()) {
            Integer nodeDepth = depth.poll();
            TreeNode tempNode = nodes.poll();
            if (nodeDepth % 2 == 0) {
                if (ans.size() <= nodeDepth) {
                    List<Integer> tempAns = new ArrayList<>();
                    tempAns.add(0, tempNode.val);
                    ans.add(tempAns);
                } else {
                    ans.get(nodeDepth).add(0,tempNode.val);
                }
            } else {
                if (ans.size() <= nodeDepth) {
                    List<Integer> tempAns = new ArrayList<>();
                    tempAns.add(tempNode.val);
                    ans.add(tempAns);
                } else {
                    ans.get(nodeDepth).add(tempNode.val);
                }
            }
            if (tempNode.right != null) {
                nodes.add(tempNode.right);
                depth.add(nodeDepth + 1);
            }
            if (tempNode.left != null) {
                nodes.add(tempNode.left);
                depth.add(nodeDepth + 1);
            }
            
        }
        return ans;
    }
}