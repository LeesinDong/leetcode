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
    // root 就是根节点，a b 分别是找最近公共祖先的两个点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // write your code here
        // 另一个即使没有在树中，只要一个是root，就返回root；
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // left right 都不是null，说明 a b就是root下面的左右两点，即left是root.left 即：root.left == p 或者 root.left == q【最上面退出条件】
        // 有一个是根节点，那公共祖先一定是根节点
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
