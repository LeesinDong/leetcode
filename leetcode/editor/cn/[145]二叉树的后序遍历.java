class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        LinkedList<Integer> output = new LinkedList<Integer>();
        if (root == null) {
            return output;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.addFirst(node.val);
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
//leetcode submit region end(Prohibit modification and deletion)
//和前序的区别就
// 1 这里是addFirst
// 2 这里是先左后右
//因为深度优先搜索后序遍历的顺序是从下到上、从左至右，所以需要将输出列表逆序输出。