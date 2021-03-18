class 链表快排{
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = head;
        while (tail != null) {
            tail = tail.next;
        }

        quickSort(head, tail);
        return head;
    }

    private void quickSort(ListNode start, ListNode end) {
        // start已经到了end那么就退出递归，说明遍历完了，找到结果了
        // if (start == null || start.next == null || start == end) {
        if (start == end) {
            return;
        }

        int pivot = start.val;
        ListNode left = start.next;
        ListNode leftPre = start;
        ListNode right = start.next;
        // while (right != end.next) {
        // 因为right用来遍历，所以应该到最后一个
        while (right != end) {
            // j比中轴值小，就i right 互换
            // left   pivot   right
            // right：遍历找到比pivot小的
            // left：锁定左右范围【只有互换了小的到左边，才i++】
            if (right.val < pivot) {
                swap(left, right);
                // 每换一次才会i++，所以j用来遍历，把比pivot小的都放到pivot左边，把比pivot大的都放大pivot右边
                leftPre = left;
                left = left.next;
            }
            right = right.next;
        }

        // 交换中轴值、leftPre 因为i_pre是j换来的，j一定比pivot小
        swap(start, leftPre);
        // printList();
        quickSort(start, leftPre);
        quickSort(left, end);
    }

    public void swap(ListNode a, ListNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}