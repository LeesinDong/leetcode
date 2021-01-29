package com.leesin.arithmetic.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Traverse {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        // Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        queue.offer(root);//queue加入head值
        while (!queue.isEmpty()) {//queue不为空的时候
            int levelNum = queue.size();//获取当前层的节点数
            //【每层都是一样的操作】
            List<Integer> list = new ArrayList<Integer>();

            for (int i = 0; i < levelNum; i++) {
                //======这里开始又和前序有点像了
                TreeNode poll = queue.poll();//出队
                // System.out.print(poll.value+ " ");//把出队的元素输出
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);//poll的left入队
                }
                if (poll.right != null) {
                    queue.offer(poll.right); //右子树入队
                }
            }
            res.add(0, list);
        }
        return res;
    }
}
