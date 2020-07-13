package code;

import java.util.Scanner;
import java.util.Stack;

public class july10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Node node =new Node();
        node.val=sc.nextInt();
        node.child = new Node();
        node.child.val=sc.nextInt();
        node.next = new Node();
        node.next.val =sc.nextInt();
        flatten(node);

    }
    public static Node flatten(Node head) {
        if(head==null){
            return head;
        }
        Node root = head;
        Stack<Node>arr =new Stack<>();
        while(head!=null){
            if(head.child!=null){
               if(head.next!=null){
                arr.push(head.next);
               }
                head.child.prev = head;
                head.next = head.child;
                head.child = null;
            }else if(head.next==null && !arr.isEmpty()){
                Node tempNode  = arr.pop();
                if(tempNode==null){
                    continue;
                }
                tempNode.prev = head;
                head.next = tempNode;
            }
            head = head.next;
        }
        return root;
    }
   
}
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};