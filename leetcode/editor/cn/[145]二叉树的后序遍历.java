class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Stack<TreeNode> stack1 = new Stack<>();
        List<Integer> res = new ArrayList<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            // stack2.push(node);
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
}
// postorderTraversal
//leetcode submit region end(Prohibit modification and deletion)