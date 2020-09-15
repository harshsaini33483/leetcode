package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sep5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final TreeNode treeNode1 = new TreeNode(sc.nextInt());
        treeNode1.left = new TreeNode(sc.nextInt());
        treeNode1.right = new TreeNode(sc.nextInt());
        // treeNode1.left.left = new TreeNode(sc.nextInt());
        // treeNode1.left.right = new TreeNode(sc.nextInt());
        // treeNode1.right.left = new TreeNode(sc.nextInt());
        // treeNode1.right.right = new TreeNode(sc.nextInt());
        final TreeNode treeNode2 = new TreeNode(sc.nextInt());
        treeNode2.left = new TreeNode(sc.nextInt());
        treeNode2.right = new TreeNode(sc.nextInt());
        // treeNode2.left.left = new TreeNode(sc.nextInt());
        // treeNode2.left.right = new TreeNode(sc.nextInt());
        // treeNode2.right.left = new TreeNode(sc.nextInt());
        // treeNode2.right.right = new TreeNode(sc.nextInt());
        getAllElements(treeNode1, treeNode2);
    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inOrder(root1, list1);
        inOrder(root2, list2);
        List<Integer> ans =new ArrayList<>();
        int lsize1 = list1.size();
        int lsize2 = list2.size();
        int i = 0, j=0;
        while(i<lsize1 || j<lsize2){
            if(i<lsize1 && j>=lsize2){
                ans.add(list1.get(i));
                ++i;
            }
            else if(i>=lsize1 && j<lsize2){
                ans.add(list2.get(j));
                ++j;
            }else if(list1.get(i)<list2.get(j)){
                ans.add(list1.get(i));
                ++i;
            }else{
                ans.add(list2.get(j));
                ++j;
            }
        }
        return list1;
    }

    public static void inOrder(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }
        inOrder(node.left, arr);
        arr.add(node.val);
        inOrder(node.right, arr);
    }
}
