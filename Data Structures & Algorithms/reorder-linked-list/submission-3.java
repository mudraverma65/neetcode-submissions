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
    public void reorderList(ListNode head) {
        Deque<ListNode> queue = new ArrayDeque<>();

        ListNode curr = head;
        while (curr != null) {
            queue.add(curr);
            curr = curr.next;
        }

        curr = queue.removeFirst();

        while (!queue.isEmpty()) {
            ListNode right = queue.removeLast();
            curr.next = right;
            curr = curr.next;

            if (!queue.isEmpty()) {
                ListNode left = queue.removeFirst();
                curr.next = left;
                curr = curr.next;
            }
        }
        curr.next = null;
    }
}
