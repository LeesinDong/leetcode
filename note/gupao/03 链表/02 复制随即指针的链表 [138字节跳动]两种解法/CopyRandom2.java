class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 得到复制的
        copy(head);
        // 构建random
        copyRandom(head);
        // 拆出整个复制链
        return split(head);
    }
    public void copy(Node head) {
        Node node = head;
        while(node != null) {
            Node copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
            // *******************
            node = copy.next;
        }
    }
    
    public void copyRandom(Node head) {
        Node node = head;
        // ******************* 注意条件是node != null ， node.next != null 不可以放到if里面
        while(node != null && node.next != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            // *******************
            node = node.next.next;
        }
    }
    
    public Node split(Node head) {
        Node result = head.next;
        Node move = head.next;
        // *******************
        while(head != null && head.next != null) {
            // 1.设置next 2.遍历
            head.next = head.next.next;
            head = head.next;
            if (move != null && move.next != null) {
                move.next = move.next.next;
                move = move.next;
            }
            // *****************这里没有head = head.next
        }
        return result;
    }
}