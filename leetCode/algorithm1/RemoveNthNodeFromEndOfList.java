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
public class Solution {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode newHead = new ListNode(0);
    newHead.next = head;
    ListNode slow = newHead;
    ListNode fast = newHead;

    while (n-- > 0) {
      fast = fast.next;
    }

    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;
    return newHead.next;
  }

}