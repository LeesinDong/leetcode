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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }

        // dummy 节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;

        // 找到m
        // 为什么是1？因为只需要找到前一个
        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        ListNode preM = head;
        ListNode mNode = head.next;
        ListNode nNode = head.next;
        ListNode postN = mNode.next;

        // 反转
        for (int i = m; i < n; i++) {
            ListNode next = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = next;
        }

        // 总体反转
        preM.next = nNode;
        mNode.next = postN;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
