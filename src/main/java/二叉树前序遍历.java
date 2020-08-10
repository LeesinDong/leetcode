import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/8/10 0010 11:57
 * @modified By:
 */


public class 二叉树前序遍历 {
//官网用的LinkedList做的栈（add()入栈，pollLast()实现出栈），这里可以直接用jdk的stack
//和之前写的唯一区别就是：将原来的sout改为了linkedList.add
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack();
            LinkedList<Integer> output = new LinkedList<Integer>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                output.add(pop.val);
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            }
            return output;
        }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
