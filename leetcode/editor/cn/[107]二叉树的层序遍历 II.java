/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();//获取当前层的节点数
            //【每层都是一样的操作】
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode poll = queue.poll();//出队
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);//poll的left入队
                }
                if (poll.right != null) {
                    queue.offer(poll.right); //右子树入队
                }
            }
            // res.add(0, list);
            res.add(list);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
