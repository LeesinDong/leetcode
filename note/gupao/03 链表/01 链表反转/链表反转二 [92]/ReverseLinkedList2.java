/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            // *******************
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        head = dummy;
        // 1 - m ，所以head 到了 preM
        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        ListNode prevM = head;
        ListNode mNode = head.next;

        // 这里开始和反转链表差不多
        ListNode nNode = mNode;
        ListNode postN = nNode.next;
        // nNode => prev;
        // postN => current
        // ***************这里不是while(xxx != null);
        for(int i = m; i < n; i++) {
            /**
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            **/
            ListNode next = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = next;
        }
        mNode.next = postN;
        prevM.next = nNode;
        return dummy.next;
    }
}