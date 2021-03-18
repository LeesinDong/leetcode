https://www.nowcoder.com/practice/650474f313294468a4ded3ce0f7898b9?tpId=117&tqId=37714&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
public class Solution {
    public boolean hasCycle(ListNode head) {
        /*
        链表有环思路：如果有环，设置一个快指针，设置一个慢指针，
        快指针一次走两步，慢指针一次走一步，快指针总能追上慢的

        本质：只要有环，快慢指针进入环，一个快一个慢，快的终有一天会和慢的相遇
        空间复杂度o1
        */
        if(head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
}