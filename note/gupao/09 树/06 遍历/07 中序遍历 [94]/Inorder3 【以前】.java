package com.leesin.arithmetic.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Traverse {
    public static void inOrder(TreeNode head) {
        //不断的把左子树往栈里面压，直到没有，然后弹出，接着把弹出右子树再往里面压
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {//stack 不为空，或者head不为null
                if (head !=null){//如果head不为null的时候，不断的把左子树压进去
                    stack.push(head);
                    head = head.left;   //先把左子树压入栈，直到没有，下面一层一层的读出左子树，读出左子树的同时，压入右子树
                }else{//否则出栈
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
    }
}
