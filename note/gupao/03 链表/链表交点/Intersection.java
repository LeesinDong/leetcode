class Solution {
    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode solution(ListNode head1, ListNode head2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (head1 != null) {
            stack1.push(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2);
            head2 = head2.next;
        }

        // 两栈不为空
        while (!stack1.empty() && !stack1.empty()) {
            // 相交的点
            result = stack1.peek(); //存第一个相交节点
            // 两个栈出来的不一样了，说明不是相交的点了，返回之前相交的点的值
            if (stack1.pop() != stack2.pop()) {
                return result;
            }
        }

        return null;
    }
}
// https://blog.csdn.net/fengxinlinux/article/details/78885764