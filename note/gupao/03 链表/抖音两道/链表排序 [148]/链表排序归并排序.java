package list;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/8/14 0014 0:57
 * @modified By:
 */
public class 链表排序归并排序 {
    public ListNode sortList(ListNode head) {
        // **************** 别忘了 head.next == null 只有一个head不需要排序！！！！，否则递归出不来了
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode next = mid.next;
        mid.next = null;
        // ****************** 核心就这一步
        ListNode listNode = mergeList(sortList(head), sortList(next));
        return listNode;
    }

    public static ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // fast.next.next != null 不是用来判空的，用来fast到了最后一个slow就是中间点，所以是跳出循环的条件
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode mergeList(ListNode head1, ListNode head2) {
        // ******************** &&
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
}
