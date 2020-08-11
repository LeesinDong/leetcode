//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 619 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        LinkedList<Integer> output = new LinkedList<Integer>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                //右边的进来还是从左边开始找
                root = root.left;
            } else {
                root = stack.pop();
                output.add(root.val);
                root = root.right;
            }
        }
        return output;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
