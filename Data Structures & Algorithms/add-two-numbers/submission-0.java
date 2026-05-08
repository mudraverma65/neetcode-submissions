/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode();
        ListNode first = curr;
        while(l1!= null && l2!= null){
            int sumVal = addNumberWithCarry(l1.val, l2.val);
            ListNode l3 = new ListNode(sumVal);
            curr.next = l3;
            curr = l3;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int sumVal = addNumberWithCarry(l1.val, 0);
            ListNode l3 = new ListNode(sumVal);
            curr.next = l3;
            curr = l3;
            l1 = l1.next;
        }

        while(l2 != null){
            int sumVal = addNumberWithCarry(l2.val, 0);
            ListNode l3 = new ListNode(sumVal);
            curr.next = l3;
            curr = l3;
            l2 = l2.next;
        }

        if(carry > 0){
            ListNode l3 = new ListNode(carry);
            curr.next = l3;
            curr = l3;
        }

        return first.next;
    }

    public int addNumberWithCarry(int a, int b){
        int sum  = a+b+carry;
        carry = sum / 10;
        return sum % 10;
    }
}
