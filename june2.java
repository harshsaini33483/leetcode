package code;

import java.util.Scanner;

public class june2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        ListNode root = new ListNode(sc.nextInt());
        ListNode currentNode = root;
        ListNode searchNode =null;
        for(int i=1;i<n;i++){
            currentNode.next = new ListNode(sc.nextInt());
            if(i==1){searchNode = currentNode.next;}
            currentNode=currentNode.next;
        }
        deleteNode(searchNode);
        while(root.next!=null){
            System.out.println(root.val);
            root = root.next;
        }
    }
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}