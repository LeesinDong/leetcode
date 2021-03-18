class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode mid = getMid(head);
        ListNode next = mid.next;
        mid.next = null;
        next = reverseList(next);
        mergeList(head, next);
    }

    public ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = head;
        ListNode current = head.next;
        pre.next = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public void mergeList(ListNode head1, ListNode head2) {
        ListNode head1Temp;
        ListNode head2Temp;
        while (head1 != null && head2 != null) {
            head1Temp = head1.next;
            head2Temp = head2.next;

            head1.next = head2;
            head1 = head1Temp;

            head2.next = head1;
            head2 = head2Temp;
        }
    }
}