/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        // current == null 没有右子，栈里面也没有了，就出来了，current != null ?因为可能没有右子了，但是只是这一层上面还没完呢。
        while (current != null || !stack.isEmpty()) {
            // current == null 没有左子 或者 没有右子
            while (current != null) {
                // 这里push的可能是左子，可能是右子[第一次进来]
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }
}