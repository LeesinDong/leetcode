package tree;

import java.util.*;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/8/11 0011 8:46
 * @modified By:
 */
//跟前序遍历的区别 1这里是queue，2这里是先左后右
class 二叉树的层次遍历 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //BFS 借助于queue进行比遍历
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        q.offer(root);
        while (!q.isEmpty()) {//每层一个循环
            int size = q.size();
            List<Integer> list = new ArrayList<Integer>();
            while (size > 0) {//一层中的节点
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null)
                    //offer就是addLast，从后面进，从前面出实现queue（linkedList）
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
                size--;
            }
            res.add(0, list);//前插，为什么往前插？
            //为什么是往前插？
            //因为每次while都是当有left，right，继续往下，左移，第一次的时候是最后一层
            //最后一次是没有left、right的，即最上面的一层
            //所以是头插

            //另外需要注意的是add() addLast()一个参数的是尾插
            //add(a,b)两个参数的是头插
        }
        return res;
    }
}
