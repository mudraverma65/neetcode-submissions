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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }
        
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;

        for(int i=1; i<left; i++){
            prev= curr;
            curr = curr.next;
        }

        ListNode beforeLeft = prev;
        ListNode leftNode = curr;

        prev=null;
        for(int i=0; i<=right-left; i++){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        beforeLeft.next = prev;
        leftNode.next = curr;

        return dummy.next;
    }
}