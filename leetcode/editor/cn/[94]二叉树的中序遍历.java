class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        LinkedList<Integer> output = new LinkedList<Integer>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.addLast(root);
                root = root.left;
            } else {
                 root = stack.pollLast();
                output.add(root.val);
                root = root.right;
            }
        }
        return output;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
