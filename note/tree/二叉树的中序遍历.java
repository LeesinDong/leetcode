package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/8/11 0011 8:30
 * @modified By:
 */
public class 二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        LinkedList<Integer> output = new LinkedList<Integer>();
        //这里是或的关系，因为下面if else 都需要 一个往里面push，一个往外面pop
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                //1 一直往里面塞左边的，只要当前有节点，就把当前节点塞进去
                stack.push(root);
                root = root.left;
            } else {
                //2 知道左边的没有了，这个时候弹出最下面的一个放进去，就是左，然后开始往右，如此往复
                root = stack.pop();
                output.add(root.val);
                root = root.right;
            }
        }
        return output;
    }
}
