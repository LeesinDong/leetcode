class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 构建双链
        copy(head);
        // 构建random
        copyRandom(head);
        // 拆成两个
        return split(head);
    }

    public void copy(Node head) {
        Node node = head;
        while (node != null) {
            Node copy = new Node(node.val);
            Node next = node.next;
            node.next = copy;
            copy.next = next;

            node = copy.next;
        }
    }

    public void copyRandom(Node head) {
        Node node = head;
        while (node != null) {
            if (node.random != null && node.next != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
    }

    public Node split(Node head) {
        Node result = head.next;
        Node node = head;
        Node move = head.next;
        while (node != null && node.next != null) {
            node.next = node.next.next;
            node = node.next;
            if (move != null && move.next != null) {
                move.next = move.next.next;
                move = move.next;
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
