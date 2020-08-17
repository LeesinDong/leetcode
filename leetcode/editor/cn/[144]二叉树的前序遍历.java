class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList();
        LinkedList<Integer> output = new LinkedList<Integer>();
        if (root == null) {
            return null;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pollLast();
            output.add(pop.val);
            if (pop.right != null) {
                stack.add(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return output;
    }
}
