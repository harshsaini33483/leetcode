package code;

import java.util.HashMap;
import java.util.Scanner;

public class july27 {
    static int currIndex=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        int inorder []=new int[n];
        int postorder[]=new int[n];
        for(int i=0;i<n;i++){
            inorder[i]=sc.nextInt(); 
        }
        for(int i=0;i<n;i++){
            postorder[i]=sc.nextInt(); 
        }
        TreeNode tree = buildTree(inorder, postorder);
        System.out.println(tree);
    }
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0){
            return null;
        }
        if(inorder.length==1){
            return new TreeNode(inorder[0]);
        }
        HashMap<Integer,Integer> hsMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hsMap.put(inorder[i],i);
        }
        currIndex = postorder.length-1;
        return BuildInOrderTree(0, postorder.length-1, inorder, postorder, hsMap );
    }


    public static TreeNode BuildInOrderTree(int start, int end, int []inorder,int []postorder, HashMap<Integer,Integer>hsMap){
       if(start>end){
           return null;
       }
       System.out.println(currIndex);
       System.out.println(postorder[currIndex]);
       
       TreeNode treeNode=new TreeNode(postorder[currIndex]);
       int num=currIndex;
       --currIndex;
       if(start==end){
           return treeNode;
       }
       
       treeNode.right= BuildInOrderTree(hsMap.get(postorder[num])+1, end, inorder, postorder, hsMap);

       treeNode.left = BuildInOrderTree(start, hsMap.get(postorder[num])-1, inorder, postorder,hsMap);

       return treeNode;
    }
}