import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/8/11 0011 8:46
 * @modified By:
 */
//跟前序遍历的区别 1这里是queue，2这里是先左后右
public class 二叉树的层次遍历 {
    public List<List<Integer>> levelOrderBottom(TreeNode head) {
        // Queue queue = new ArrayDeque();
        // LinkedList<Integer> output = new LinkedList<Integer>();
        // queue.offer(head);
        // while (!queue.isEmpty()) {
        //     int size = queue.size();
        //     for (int i = 0; i < size; i++) {
        //         TreeNode poll = (TreeNode) queue.poll();
        //         System.out.print(poll.val);
        //         output.add(poll.val);
        //         if (poll.left != null) {
        //             queue.offer(poll.left);
        //         }
        //         if (poll.right != null) {
        //             queue.offer(poll.right);
        //         }
        //     }
        // }
        // return output;
        return null;
    }
}
