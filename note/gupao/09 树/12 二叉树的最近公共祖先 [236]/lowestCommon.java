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
    // root 就是根节点，a b 分别是找最近公共祖先的两个点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
          // write your code here
            if(root == null || root == A || root == B) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, A, B);
            TreeNode right = lowestCommonAncestor(root.right, A, B);
            // left right 都不是null，说明 a b就是root下面的左右两点
            if (left != null && right != null) {
                return root;
            }
            // a b 在左子树
            if (left != null) {
                return left;
            }
            // a b 在右子树
            if (right != null) {
                return right;
            }

            return null;

    }
}
