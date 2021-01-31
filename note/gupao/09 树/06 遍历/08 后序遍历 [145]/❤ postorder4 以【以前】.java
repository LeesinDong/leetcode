public class Traverse {
    // 唯一区别：方法一直接到List中，对list逆序；方法二先到栈中，在逆序到List中
    // ArrayList逆序本身就像栈 LinkedList本身就是Queue

    /**
     * 方法一
     * @param root
     * @return
     */
    public static List<Integer> postOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Stack<TreeNode> stack1 = new Stack<>();
        List<Integer> res = new ArrayList<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            res.add(node.val);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 方法一
     * @param root
     * @return
     */
    public static List<Integer> postOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode pop = stack1.pop();
            stack2.push(pop);
            if (pop.left != null) {
                stack1.push(pop.left);
            }
            if (pop.right!=null) {
                stack1.push(pop.right);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }
        return result;
    }
}
