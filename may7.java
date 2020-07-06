package code;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class may7 {

 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         TreeNode treeNode = new TreeNode(sc.nextInt(),null, null);
         treeNode.left = new TreeNode(sc.nextInt(), null, null);
         treeNode.right = new TreeNode(sc.nextInt(), null, null);
         treeNode.left.left = new TreeNode(0, null, null);
         treeNode.left.right = new TreeNode(sc.nextInt(), null, null);
         treeNode.right.left = new TreeNode(0, null, null);
         treeNode.right.right = new TreeNode(sc.nextInt(), null, null);
        
         int first[] = findSolution(treeNode, sc.nextInt());
         int second[] = findSolution(treeNode, sc.nextInt());
         if(first[0]==second[0] && first[1]!=second[1]){
             System.out.println(true);
         }else{
             System.out.println(false);
         }
    //        1
    //       / \
    //      2    3
    //     / \   / \
    //    4  nu  5  6


    }
   public static int[] findSolution(TreeNode node, int num1 ){
    Stack<TreeNode> qu =new Stack<>();
    Stack<Integer> pos =new Stack<>();
    Stack<Integer> parent = new Stack<>();
    int arr[]=new int[2];
    qu.push(node);
    pos.push(0);
    parent.push(0);
    while(!qu.isEmpty()){
        TreeNode temp = qu.pop();
        int tempPos = pos.pop();
        int tempPar = parent.pop();

        if(temp!=null && temp.val!=0){
            if(temp.val==num1){
                 arr[0]=tempPos;
                 arr[1]=tempPar;
                 return arr;
            }else{
                qu.push(temp.right);
                pos.push(tempPos+1);
                pos.push(tempPos+1);
                qu.push(temp.left);
                parent.push(temp.val);
                parent.push(temp.val);
            }
        }
    }
    return arr;
   }
}
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}