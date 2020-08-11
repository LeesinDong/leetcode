有两种通用的遍历树的策略：

* *深度优先搜索*（`DFS`）

  在这个策略中，我们采用`深度`作为优先级，以便从跟开始一直到达某个确定的叶子，然后再返回根到达另一个分支。

  深度优先搜索策略又可以根据根节点、左孩子和右孩子的相对顺序被细分为`前序遍历`，`中序遍历`和`后序遍历`。

* *宽度优先搜索*（`BFS`）

  我们按照高度顺序一层一层的访问整棵树，高层次的节点将会比低层次的节点先被访问到。

下图中的顶点按照访问的顺序编号，按照 `1-2-3-4-5` 的顺序来比较不同的策略。

![102.png](https://pic.leetcode-cn.com/071065c80aaf44da930c7ccb2156b3eac6309d446eb36a376d6478d17cc2400f-102.png)


本问题就是用宽度优先搜索遍历来划分层次：`[[1], [2, 3], [4, 5]]`。

#### 方法 1：迭代

**算法**

首先，定义树的存储结构 `TreeNode`。

```Java []
/* Definition for a binary tree node. */
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}
```

```Python []
class TreeNode(object):
    """ Definition of a binary tree node."""
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
```

从根节点开始，每次迭代弹出当前栈顶元素，并将其孩子节点压入栈中，先压右孩子再压左孩子。

在这个算法中，输出到最终结果的顺序按照 `Top->Bottom` 和 `Left->Right`，符合前序遍历的顺序。

```Java []
class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    LinkedList<TreeNode> stack = new LinkedList<>();
    LinkedList<Integer> output = new LinkedList<>();
    if (root == null) {
      return output;
    }

    stack.add(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pollLast();
      output.add(node.val);
      if (node.right != null) {
        stack.add(node.right);
      }
      if (node.left != null) {
        stack.add(node.left);
      }
    }
    return output;
  }
}
```
```Python []
class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root is None:
            return []
        
        stack, output = [root, ], []
        
        while stack:
            root = stack.pop()
            if root is not None:
                output.append(root.val)
                if root.right is not None:
                    stack.append(root.right)
                if root.left is not None:
                    stack.append(root.left)
        
        return output
```

**算法复杂度**

* 时间复杂度：访问每个节点恰好一次，时间复杂度为 *O(N)* ，其中 *N* 是节点的个数，也就是树的大小。
* 空间复杂度：取决于树的结构，最坏情况存储整棵树，因此空间复杂度是 *O(N)*。

#### 方法 2：莫里斯遍历

方法基于 [莫里斯的文章](https://www.sciencedirect.com/science/article/pii/0020019079900681)，可以优化空间复杂度。算法不会使用额外空间，只需要保存最终的输出结果。如果实时输出结果，那么空间复杂度是 *O(1)*。

**算法**

算法的思路是从当前节点向下访问先序遍历的前驱节点，每个前驱节点都恰好被访问两次。

首先从当前节点开始，向左孩子走一步然后沿着右孩子一直向下访问，直到到达一个叶子节点（当前节点的中序遍历前驱节点），所以我们更新输出并建立一条伪边 `predecessor.right = root` 更新这个前驱的下一个点。如果我们第二次访问到前驱节点，由于已经指向了当前节点，我们移除伪边并移动到下一个顶点。

如果第一步向左的移动不存在，就直接更新输出并向右移动。

 ![image.png](https://pic.leetcode-cn.com/af8aa01dc6b551be989b9d6e98fc78ccd6f5df1066fd7cf7b1c06e7201ef219b-image.png) ![image.png](https://pic.leetcode-cn.com/dc7b475d8243268d52922a65154d9d8e36e867b443b9bf505799963a03f39f3e-image.png) ![image.png](https://pic.leetcode-cn.com/7ebbe8ee238e1faf5ec2e8bd263297660620eefaeaad3e63270efc98be80a4dc-image.png) ![image.png](https://pic.leetcode-cn.com/61550b84f641c951d2930efd43aac9d425107c63bf0841c0ccf77c7f86a88541-image.png) ![image.png](https://pic.leetcode-cn.com/b0d587de344a331d28f747d168ead3d66ce5bc19e607a4d269c586cbba7f0156-image.png) ![image.png](https://pic.leetcode-cn.com/f59f2d3e28c4e171e0ffe313ef927c69c4e2b75c0c4539f96c8de80254d3e649-image.png) ![image.png](https://pic.leetcode-cn.com/c6c82174b8c26762759139b23b0c393f0f0df7f77389797f4af65be39c389d97-image.png) ![image.png](https://pic.leetcode-cn.com/a83c8633c8869ac7101b3e232b36717e0f37b8846b7e271209583ac68b477d96-image.png) ![image.png](https://pic.leetcode-cn.com/011548396d8eee967aee55dbe267d8b97c6ebd8e4fd2ab842254966b64fc660a-image.png) ![image.png](https://pic.leetcode-cn.com/8f7ede1bb13128af523a979788511714734689a3cb0587c2d9ae5242fcb227d0-image.png) ![image.png](https://pic.leetcode-cn.com/896e602444dbc2bafd34959ae310a2a436529ff26d68de3a6dc556a8dedea956-image.png) ![image.png](https://pic.leetcode-cn.com/c728f7c09fce71ed8c97fc2e58cacd4b9574da16cae903b4c391c536daa37907-image.png) ![image.png](https://pic.leetcode-cn.com/da8b53dbadab269c81615c69939fd871597ca9d3ee584b190dd258bbf5923f8a-image.png) ![image.png](https://pic.leetcode-cn.com/752b653f1df69a73824a51bdfbaff9a4dc2c4325ac5372775b562a273b609bf7-image.png) ![image.png](https://pic.leetcode-cn.com/6a4120b10aded4fc9db5d7d1526d55a613991c5c307e58fd35b8c8e76ef9f38a-image.png) ![image.png](https://pic.leetcode-cn.com/b7797837756c5f51c066221f0f3fa3669021c9426cda93862a15c9d3830b3219-image.png) 

```Java []
class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    LinkedList<Integer> output = new LinkedList<>();

    TreeNode node = root;
    while (node != null) {
      if (node.left == null) {
        output.add(node.val);
        node = node.right;
      }
      else {
        TreeNode predecessor = node.left;
        while ((predecessor.right != null) && (predecessor.right != node)) {
          predecessor = predecessor.right;
        }

        if (predecessor.right == null) {
          output.add(node.val);
          predecessor.right = node;
          node = node.left;
        }
        else{
          predecessor.right = null;
          node = node.right;
        }
      }
    }
    return output;
  }
}
```

```Python []
class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        node, output = root, []
        while node:  
            if not node.left: 
                output.append(node.val)
                node = node.right 
            else: 
                predecessor = node.left 

                while predecessor.right and predecessor.right is not node: 
                    predecessor = predecessor.right 

                if not predecessor.right:
                    output.append(node.val)
                    predecessor.right = node  
                    node = node.left  
                else:
                    predecessor.right = None
                    node = node.right         

        return output
```

**算法复杂度**

* 时间复杂度：每个前驱恰好访问两次，因此复杂度是 *O(N)*，其中 *N* 是顶点的个数，也就是树的大小。
* 空间复杂度：我们在计算中不需要额外空间，但是输出需要包含 *N* 个元素，因此空间复杂度为 *O(N)*。