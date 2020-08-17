class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> output = new LinkedList<List<Integer>>();
        if (root == null) {
            return output;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<Integer>();
            while (size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            output.add(0, list);
        }
        return output;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
//跟前序遍历的区别 1这里是queue，2这里是先左后右
