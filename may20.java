package code;

import java.util.Scanner;
import java.util.Stack;

public class may20 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeNodeS tree = new TreeNodeS(sc.nextInt(), null, null);
        tree.left = new TreeNodeS(sc.nextInt(), null, null);
        tree.right = new TreeNodeS(sc.nextInt(), null, null);
        tree.left.left = new TreeNodeS(sc.nextInt(), null, null);
        tree.left.right = new TreeNodeS(sc.nextInt(), null, null);
     //   tree.right.left = new TreeNodeS(sc.nextInt(), null, null);
     //   tree.right.right = new TreeNodeS(sc.nextInt(), null, null);
         tree.left.left.left = new TreeNodeS(sc.nextInt(), null, null);
        System.out.println(tree.kthSmallest(tree, sc.nextInt()));
    }
}

 class TreeNodeS {
      int val;
      TreeNodeS left;
      TreeNodeS right;
      TreeNodeS() {}
      TreeNodeS(int val) { this.val = val; }
      TreeNodeS(int val, TreeNodeS left, TreeNodeS right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
      int finNum = 0;
      public int kthSmallest(TreeNodeS root, int k) {
        if(root==null){
              return 0;
        }
       Stack<TreeNodeS> stack = new Stack<>();
       TreeNodeS curr = root;
      
       while(!stack.isEmpty() || curr!=null){

          while(curr!=null){
              stack.push(curr);
              curr= curr.left;
          }
         TreeNodeS temp = stack.pop();
         --k;
         if(k==0){
             return temp.val;
         }
         curr = temp.right;
       }
       return 0;
    }
  }
 