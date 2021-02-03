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
     public boolean isBalanced(TreeNode root) {
        // write your code here
        // 空树，高度平衡
         if(root == null) {
            return true;
         }
         return maxTree(root) != -1;
    }
    
    public int maxTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxTree(node.left);
        int right = maxTree(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            // 是平衡二叉树就返回最大的高度
            // 因为左右高度差不能大于1  每次迭代高度高的+1 即是最新的高度
            return Math.max(left, right) + 1;
        }
    }
    
}