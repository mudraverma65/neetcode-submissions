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
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> minQueue = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
    for (ListNode currList : lists) {
      if (currList != null) {
        minQueue.offer(currList);
      }
    }

    ListNode head = new ListNode(0);
    ListNode dummy = head;

    while (!minQueue.isEmpty()) {
      ListNode currMin = minQueue.poll();
      if (currMin.next != null) {
        minQueue.offer(currMin.next);
      }
      dummy.next = currMin;
      dummy = dummy.next;
    }

    dummy.next = null;
    return head.next;
  }
}
