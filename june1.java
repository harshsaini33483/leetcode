package code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class june1 {
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        final TreeNode treeNode = new TreeNode(sc.nextInt());
       // treeNode.left = new TreeNode(sc.nextInt());
        treeNode.right = new TreeNode(sc.nextInt());
       // treeNode.left.left = new TreeNode(sc.nextInt());
      //  treeNode.left.right = new TreeNode(sc.nextInt());
        treeNode.right.left = new TreeNode(sc.nextInt());
        // treeNode.left = new TreeNode(sc.nextInt());
        // treeNode.left = new TreeNode(sc.nextInt());
        // treeNode.left = new TreeNode(sc.nextInt());
        /*
         * 6 / \ 3 7 / \ / 2 4 10
         * 
         * ans 6 / \ 7 3 \ / \ 10 4 2
         * 
         */
        invertTree(treeNode);
    }

    public static TreeNode invertTree(final TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode secondTree = new TreeNode(root.val);
        Queue<TreeNode> queLinkedList = new LinkedList<>();
        Queue<TreeNode> revLinkedList = new LinkedList<>();
        queLinkedList.add(root);
        revLinkedList.add(secondTree);
        while (queLinkedList.size() != 0) {
            TreeNode bfsNode = queLinkedList.poll();
            TreeNode revbfsNode = revLinkedList.poll();
            if (bfsNode.left != null && bfsNode.right != null) {
                revbfsNode.right = new TreeNode(bfsNode.left.val);
                revbfsNode.left = new TreeNode(bfsNode.right.val);
                queLinkedList.add(bfsNode.left);
                queLinkedList.add(bfsNode.right);
                revLinkedList.add(revbfsNode.right);
                revLinkedList.add(revbfsNode.left);
            } else if (bfsNode.left != null) {
                revbfsNode.right = new TreeNode(bfsNode.left.val);
                queLinkedList.add(bfsNode.left);
                revLinkedList.add(revbfsNode.right);
            } else if (bfsNode.right != null) {
                revbfsNode.left = new TreeNode(bfsNode.right.val);
                queLinkedList.add(bfsNode.right);
                revLinkedList.add(revbfsNode.left);
            }
        }
        return secondTree;
    }
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }
}