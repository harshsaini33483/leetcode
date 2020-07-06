package code;

import java.util.Scanner;

public class may24 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int array[]=new int[n];
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        bstFromPreorder(array);
    }
    public static TreeNode2 bstFromPreorder(int[] preorder) {
        if(preorder.length==0){
            return new TreeNode2();
        }
        // Input: [8,5,1,7,10,12]
        // Output: [8,5,10,1,7,null,12]
        TreeNode2 root =new TreeNode2(preorder[0]);
        for(int i=1;i<preorder.length;i++){
            int num = preorder[i];
            TreeNode2 tempRoot = root;
            TreeNode2 parentRoot = root;
            boolean isRight = false;
            while(tempRoot!=null){
                if(tempRoot.val<num){
                    isRight = true;
                    parentRoot=tempRoot;
                    tempRoot=tempRoot.right;
                }else{
                    isRight=false;
                    parentRoot=tempRoot;
                    tempRoot= tempRoot.left;
                }
            }
            if(isRight){
                parentRoot.right= new TreeNode2(num);
            }else{
                parentRoot.left=new TreeNode2(num);
            }
        }
        return root;

    }
}
class TreeNode2 {
         int val;
         TreeNode2 left;
         TreeNode2 right;
         TreeNode2() {}
         TreeNode2(int val) { this.val = val; }
         TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }