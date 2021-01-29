package com.leesin.arithmetic.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
public class Traverse {
    public static void preOrder(TreeNode head) {
        //采用栈
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);//根节点push进去，进栈
            while (!stack.empty()) {
                TreeNode pop = stack.pop();
                //根左右   --》 根【右 左】  头先出来，所以 头正序 ，左右逆序
                System.out.print(pop.value + " ");
                if (pop.right!=null) {//右子树是不是为空，不为空的时候压栈
                    stack.push(pop.right);//注意这里先压右子树，再压左子树 pop.right注意是pop，即下次while上去的
                }
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            }
        }
    }
}
