class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        List<Integer> result = new ArrayList<>();
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode treeNode = stack.pop();
            result.add(treeNode.val);
            current = treeNode.right;
        }
        return result;
     }
}
//leetcode submit region end(Prohibit modification and deletion)


