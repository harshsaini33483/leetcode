package code;

import java.util.Scanner;

public class may16 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ListNode root = new ListNode(sc.nextInt(), null);
        ListNode currentNode =root;
        for(int i=1;i<n;i++){
            ListNode tempNode = new ListNode(sc.nextInt(), null);
            currentNode.next =tempNode;
            currentNode=currentNode.next;
        }
        ListNode newRoot =oddEvenList(root);
        while(newRoot!=null){
            System.out.print(newRoot.val+"->");
            newRoot=newRoot.next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode startNode =head;
        
        if(startNode.next==null){
            return startNode;
        }
        ListNode secStart = head.next;
        ListNode tempStart =startNode;
        ListNode tempSecStart =secStart;
        int i=1;
        while(true){
            if(i%2!=0){
                if(tempSecStart.next!=null){
                    tempStart.next = tempSecStart.next;
                    tempStart = tempStart.next ;
                }else{
                    break;
                }
            }else{
                if(tempStart.next!=null){
                    tempSecStart.next = tempStart.next;
                    tempSecStart = tempSecStart.next ;
                }else{
                    break;
                }
            }
            ++i;
        }
       
        tempSecStart.next=null;
       tempStart.next=secStart;
       return startNode;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
