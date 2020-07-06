package code;

import java.util.Scanner;

public class AddTwoNumber {
    public static void main(String[] args) {
        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode();
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        ListNode tempList1 = list1;
        ListNode tempList2 = list2;
        for (int i = 0; i < n1; i++) {
            tempList1.val = sc.nextInt();
            tempList1.next = new ListNode();
            tempList1 = tempList1.next;
        }
        for (int i = 0; i < n2; i++) {
            tempList2.val = sc.nextInt();
            tempList2.next = new ListNode();
            tempList2 = tempList2.next;
        }
        ListNode ans = addTwoNumbers(list1, list2);
        sc.close();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)   return l2;
        if(l2 == null)   return l1;
        
        ListNode n1 = l1;
        ListNode n2 = l2;
        
        int carry = 0;
        ListNode res = new ListNode(-1);
        ListNode ptr = res;
        while(n1 != null || n2 != null){
            int f1 = n1 == null ? 0 : n1.val;
            int f2 = n2 == null ? 0 : n2.val;
            int sum = f1 + f2 + carry;
            carry = sum/10;
            ptr.next = new ListNode(sum%10);
            ptr = ptr.next;
            if(n1 != null)   n1 = n1.next;
            if(n2 != null)   n2 = n2.next;
        }
        
        if(carry > 0){
            ptr.next = new ListNode(carry);
            ptr = ptr.next;
        }
        
        return res.next;
    }
}