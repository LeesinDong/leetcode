class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);

        List<Integer> result = new ArrayList<Integer>();
        result.addAll(left);
        result.add(root.val);
        result.addAll(right);
        return result;
     }
}
//leetcode submit region end(Prohibit modification and deletion)


