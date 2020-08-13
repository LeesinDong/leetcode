### 解题思路
只需要在层次遍历的基础上使用前插法：
    ```
    void add(int index, E element);
    ```
    将元素插入List的指定位置，其他元素后移

### 代码

```java
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {       
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        //BFS
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {//每层一个循环
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while(size > 0) {//一层中的节点
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null)
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
```