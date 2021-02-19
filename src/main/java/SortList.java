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

        ListNode l1 = list[0];
        ListNode l2 = list[1];
        l2 = reverseList(l2);

        // while (l1 != null) {
        //     System.out.println(l1.val);
        //     l1 = l1.next;
        // }
        // System.out.println("__________");
        //
        // while (l2 != null) {
        //     System.out.println(l2.val);
        //     l2 = l2.next;
        // }
        // System.out.println("__________");

        ListNode ln = merge(l1, l2);
        while (ln != null) {
            System.out.println(ln.val);
            ln = ln.next;
        }
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1 ==null) {
            return l2;
        }

        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            head.next = merge(l1.next, l2);
        } else {
            head  = l2;
            head.next = merge(l2.next, l1);
        }
        return head;
    }

    private static ListNode reverseList(ListNode head) {
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
                    curl2 = curl2.next;
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

