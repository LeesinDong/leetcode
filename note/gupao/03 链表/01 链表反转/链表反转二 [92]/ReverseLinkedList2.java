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
        /**
         * m >= n 是判断入参是否符合题中给的，是否符合提议
         */
        if (head == null || m >= n) {
            // *******************
            return head;
        }

        /**
         * 加入哨兵节点
         * 因为极端情况m在第一个且n不在最后一个
         */
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;

        /**
         * 找到preM
         * 为什么是 1 到 m ？
         * 1 i = n ; i < m 【万能公式！！！】，循环了 m - n 次，n = 0 亦是如此
         * 2 当 m = 2 的时候，2指的不是数组下标，而就是第2个，从 -1 1 2 从 -1 到 1需要一次，所以想办法让m - n = 1 这个m要和m（第2个）有关
         * 故 m - x = 1； m = 2，x = 1 故 1 到 m
         */
        // 1 到 m ，所以 head 到了 preM
        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        ListNode prevM = head;
        ListNode mNode = head.next;

        /**
         * 反转链表开始【m 到 n】
         * n 和 postN 就是 pre 和 current
         * n - m 次，n从m正好到了n
         */
        // 这里开始和反转链表差不多
        ListNode nNode = mNode;
        ListNode postN = nNode.next;
        // nNode => prev;
        // postN => current
        // ***************这里不是while(xxx != null);
        /**
         * 为什么 m 到 n ? m - n 次，极端情况两个，m - n = 1， 则需要往后挪一次，所以m - n 符合
         */
        for(int i = m; i < n; i++) {
            /*
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            */
            ListNode next = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = next;
        }

        /**
         * 连接新旧链表
         * postN最后到了原来n后面
         * prevM一直在原来m前面
         * m n 互换了位置
         */
        mNode.next = postN;
        prevM.next = nNode;
        return dummy.next;
    }
}