package list;

import javafx.scene.transform.Rotate;

import java.awt.event.HierarchyBoundsAdapter;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/8/12 0012 17:44
 * @modified By:
 */
//leetcode 奇数位升序,偶数位降序链表排序
public class SortList {

    public static ListNode[] getLists(ListNode head) {
        if (head == null) {
            return null;
        }
        // 两个头结点
        ListNode head1 = null;
        ListNode head2 = null;
        // 两个指针，遍历用
        ListNode curl1 = null;
        ListNode curl2 = null;

        // ************************ 这里必须是1，第几位 而不是0，否则下面的 1/1 == 0 已经到了第二个数，即偶数位，但是会到奇数位的链表里。
        int count = 1;
        while (head != null) {
            // ********************************* 1的时候是：奇数位
            if (count % 2 == 1) {
                if (curl1 == null) { // 最开始情况
                    curl1 = head;
                    head1 = curl1;
                } else {
                    // *************************** curl1.next 而不是head1.next
                    curl1.next = head; //
                    curl1 = curl1.next; // 遍历
                }
            } else if (count % 2 == 0){
                // 偶数位
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

    public static ListNode reverseList(ListNode head) {
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

    public static ListNode mergeTwoList(ListNode head1, ListNode head2) {
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
            head.next = mergeTwoList(head1.next, head2);
        } else {
            head = head2;
            head.next = mergeTwoList(head2.next, head1);
        }
        return head;
    }
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
        //拆分成奇数、偶数两个链表
        ListNode[] lists = getLists(head);

        //得到两个链表头结点
        ListNode head1 = lists[0];
        ListNode head2 = lists[1];

        //***********************************************偶数链表反转
        head2 = reverseList(head2);

        //两个链表合并
        head =  mergeTwoList(head1, head2);

        while (head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
