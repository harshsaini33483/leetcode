package code;

import java.util.Scanner;

public class july20 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;
        for(int i=0;i<n-1;i++){
            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }
        int val = sc.nextInt();
        removeElements(head, val);
    }
    public  static ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        while(head!=null && head.val==val){
            head = head.next;
        }
        ListNode tempHead = head;
        ListNode prevNode = head;
        while(tempHead!=null){
            if(tempHead.val==val){
                prevNode.next = tempHead.next;
            }else{
                prevNode = tempHead;
            }
            tempHead = tempHead.next;
        }
        return head;
    }
}