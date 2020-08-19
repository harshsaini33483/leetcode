package code;

import java.util.*;

public class aug7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        final TreeNode treeNode = new TreeNode(sc.nextInt());
        treeNode.left = new TreeNode(sc.nextInt());
        treeNode.right = new TreeNode(sc.nextInt());
       // treeNode.left.left = new TreeNode(sc.nextInt());
        // treeNode.left.right = new TreeNode(sc.nextInt());
        treeNode.right.left = new TreeNode(sc.nextInt());
        treeNode.right.right = new TreeNode(sc.nextInt());
        verticalTraversal(treeNode);
    }
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Map<Integer, ArrayList<PointA>>hsMap = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<PointA> pos = new LinkedList<>();

        List<List<Integer>> ans = new ArrayList<>();
        queue.add(root);
        pos.add(new PointA(0,0,root.val));
        while(!queue.isEmpty()){
            TreeNode tempNode = queue.poll();
            PointA tempPos = pos.poll();
            if(hsMap.containsKey(tempPos.x)){
                hsMap.get(tempPos.x).add(new PointA(tempPos.x, tempPos.y, tempNode.val));
            }else{
                ArrayList<PointA> arr = new ArrayList<>();
                arr.add(new PointA(tempPos.x, tempPos.y, tempNode.val));
                hsMap.put(tempPos.x,arr);
            }
            if(tempNode.left!=null){
                queue.add(tempNode.left);
                pos.add(new PointA(tempPos.x-1, tempPos.y-1, tempNode.left.val));
            }
            if(tempNode.right!=null){
                queue.add(tempNode.right);
                pos.add(new PointA(tempPos.x+1, tempPos.y-1, tempNode.right.val));
            }
           
        }
        for(Map.Entry<Integer, ArrayList<PointA>>tempMa: hsMap.entrySet()){
            ArrayList<PointA> tempArr = tempMa.getValue();
            Collections.sort(tempArr, (p1, p2) -> p1.x == p2.x ? p1.y == p2.y ? p1.val- p2.val : p2.y - p1.y : p1.x - p2.x);
            ArrayList<Integer> addArr = new ArrayList<>();
            for(PointA x: tempArr){
              addArr.add(x.val);
            }
        ans.add(addArr);
        }
        return ans;
    }
    
  
}
  
class PointA {
    int x;
    int y;
    int val;
    public PointA(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}