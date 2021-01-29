package com.leesin.arithmetic.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @description: 二叉树遍历
 * @author: Leesin Dong
 * @date: Created in 2020/6/30 0030 22:46
 * @modified By:
 */
public class Traverse {
    public static List<Integer> postOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode pop = stack1.pop();
            stack2.push(pop);
            if (pop.left != null) {
                stack1.push(pop.left);
            }
            if (pop.right!=null) {
                stack1.push(pop.right);
            }
        }

        // stack2中即为所求
        List<Integer> result = new ArrayList<>();
        while (!stack2.isEmpty()) {
            result.add(stack2.pop()val);
        }
    }
}
