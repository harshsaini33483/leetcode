package code;
import java.util.Scanner;

public class aug20 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        ListNode head = new ListNode(sc.nextInt());
        ListNode tempHead = head;
        for(int i=1;i<n;i++){
            tempHead.next = new ListNode(sc.nextInt());
            tempHead = tempHead.next;
        }
        secondSolution(head);
    }
    public static void reorderList(ListNode head) {
        if(head==null){
            return;
        }
        ListNode tempHead = head;
        ListNode reverseNode = reverseList(head);
        while(tempHead.next!=null){
            if(tempHead.next!=null && reverseNode!=null && head.next.val==reverseNode.val){
                break;
            }else{
                ListNode tempNode = tempHead.next;
                
                tempHead.next= reverseNode;
             //   tempHead.next
            }
          
        }
        System.out.println(reverseNode);
    }
    public static ListNode reverseList(ListNode head){
        ListNode reverseHead = new ListNode(head.val);
        ListNode tempHead = head;
        while(tempHead.next!=null){
            ListNode tempNode = new ListNode(tempHead.next.val);
            tempNode.next = reverseHead;
            reverseHead = tempNode;
            tempHead=tempHead.next;

        }
        return reverseHead;
    }
    public static void secondSolution(ListNode head){
        if(head==null){
            return ;
        }
        ListNode tempHead = head;
        while(tempHead.next!=null){
            ListNode nextNode = tempHead.next;
            ListNode traverseNode = tempHead;
            ListNode prevNode = traverseNode;
            while(traverseNode.next!=null){
                prevNode = traverseNode;
                traverseNode = traverseNode.next;
            }
            tempHead.next=traverseNode;
            traverseNode = null;
            prevNode.next=null;
            if(tempHead.next!=null){
                tempHead=tempHead.next;
            }
         
           tempHead.next=nextNode;
     
            if(tempHead.next!=null){
                tempHead =tempHead.next;
            }
            
        }
    }
}
/*
1->2->3->4-5-6
6-5-4-3-2-1

1-6-2-5-3-4

*/