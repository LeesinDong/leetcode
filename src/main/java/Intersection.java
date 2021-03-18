import javax.xml.transform.Result;
import java.util.Stack;

public class Intersection {
    class ListNode{
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

        while (!stack1.isEmpty() && stack2.isEmpty()) {
            ListNode result = stack1.peek();

            stack1.pop();
            stack2.pop();
            if (stack1.peek() != stack2.peek()) {
                return result;
            }
        }
        return result;
    }
}
