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

         // 不是 -1 就是平衡二叉树
         return maxHeight(root) != -1;
    }
    
    public int maxHeight(TreeNode node) {
        // 没有节点高度是0；
        if (node == null) {
            return 0;
        }

        // 左子树、右子树的高度
        int left = maxHeight(node.left);
        int right = maxHeight(node.right);

        // 递归上来的有一个节点不平衡，直接往上吐出去，不平衡
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;

        } else {
            // 是平衡二叉树就返回最大的高度
            // 因为左右高度差不能大于1  每次迭代高度高的+1 即是最新的高度，因为这是自己这层的高度，下面是自己左右子树的高度
            return Math.max(left, right) + 1;
        }
    }
    
}