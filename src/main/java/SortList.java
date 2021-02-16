import java.util.zip.CheckedOutputStream;

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
        ListNode node = init();
        ListNode[] lists = getLists(node);
        ListNode list1 = lists[0];
        ListNode list2 = lists[1];
        list2 = reverseLsit(list2);
        ListNode head = mergeList(list1, list2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static ListNode mergeList(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
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

    private static ListNode reverseLsit(ListNode head) {
        if (head == null) {
            return head;
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


    private static ListNode[] getLists(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode head1 = null;
        ListNode head2 = null;
        ListNode curl1 = null;
        ListNode curl2 = null;
        int count = 0;
        while (head != null) {
            if (count % 2 == 0) {
                if (curl1 == null) {
                    curl1 = head;
                    head1 = curl1;
                } else {
                    curl1.next = head;
                    curl1 = curl1.next;
                }
            } else {
                if (curl2 == null) {
                    curl2 = head;
                    head2 = curl2;
                } else {
                    curl2.next = head;
                    curl2 = curl1.next;
                }
            }
            count++;
            head = head.next;
        }
        curl1.next = null;
        curl2.next = null;
        return new ListNode[]{head1, head2};
    }


}
