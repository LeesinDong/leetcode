import com.sun.org.apache.regexp.internal.REUtil;
import sun.util.resources.ar.CurrencyNames_ar_TN;

import java.util.List;

public class SortList {
    public static ListNode init() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(2);
        ListNode node9 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        return node1;
    }

    public static void main(String[] args) {
        ListNode head = init();
        ListNode[] list = getLists(head);
        ListNode head1 = list[0];
        ListNode head2 = list[1];
        head2 = reverseList(head2);
        ListNode newHead = mergeList(head1, head2);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    private static ListNode mergeList(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode head = null;
        if (head1.val < head2.val) {
            head = head1;
            head.next = mergeList(head1.next, head2);
        } else {
            head = head2;
            head.next = mergeList(head2.next, head1);
        }
        return head;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private static ListNode[] getLists(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode head1 = null;
        ListNode head2 = null;
        ListNode curl1 = null;
        ListNode curl2 = null;
        int count = 1;
        while (head != null) {
            if (count % 2 == 1) {
                if (curl1 == null) {
                     curl1 = head;
                     head1 = curl1;
                } else {
                    curl1.next= head;
                    curl1 = curl1.next;
                }
            } else {
                if (curl2 == null) {
                    curl2 = head;
                    head2 = curl2;
                } else {
                    curl2.next = head;
                    curl2 = curl2.next;
                }
            }

            head = head.next;
            count++;
        }
        curl1.next = null;
        curl2.next = null;
        return new ListNode[]{head1, head2};

    }


}

