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
        if(root == null)
            return res;
        q.offer(root);
        while(!q.isEmpty()) {//每层一个循环
            int size = q.size();
            List<Integer> list = new ArrayList<Integer>();
            while(size > 0) {//一层中的节点
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null)
                    //offer就是addLast，从后面进，从前面出实现queue（linkedList）
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
                size--;
            }
            res.add(0,list);//前插
        }
        return res;
    }
}
