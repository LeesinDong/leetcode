package tree;

import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/8/11 0011 8:34
 * @modified By:
 */
//和前序的区别就
// 1 这里是addFirst
// 2 这里是先左后右
//因为深度优先搜索后序遍历的顺序是从下到上、从左至右，所以需要将输出列表逆序输出。
public class 二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> output = new Stack<Integer>();
        if (root == null) {
            return output;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            //区别就是这里，这里是addFirst，所以就是栈如队列
            //也就是后续和前序的区别就是，这里是stack，前序是list
            output.push(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return output;
    }
}
