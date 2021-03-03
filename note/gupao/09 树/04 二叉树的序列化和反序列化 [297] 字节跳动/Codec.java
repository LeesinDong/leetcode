/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }

        // 树结构装载到list
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        // [1, 2, 3, null, null, 4, 5, null, null, null, null]
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                continue;
            }

            list.add(list.get(i).left);
            list.add(list.get(i).right);
        }

        // 删掉最后一行多余的null，因为树太大的时候，最后一行null会很多
        // [1, 2, 3, null, null, 4, 5]
        while (list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }

        // 根据list进行序列化 {1,2,3,#,#,4,5}
        StringBuilder sb = new StringBuilder("{");
        // ************************************** val
        sb.append(list.get(0).val);//第一个先append，因为下面前面会append,
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == null) {
                sb.append(",").append("#");
                continue;
            }

            sb.append(",").append(list.get(i).val);
        }
        sb.append("}");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.equals("{}")) {
            return null;
        }
        // String[] data = 1 2 3 # # 4 5 ，去掉了 {} 第一个和最后一个
        String[] arr = data.substring(1, data.length() - 1).split(",");
        // 就是通过left控制的
        boolean isLeft = true;

        // 为什么不能是queue，因为下面的某个要重复的用，用来保存根节点的。
        List<TreeNode> list = new ArrayList<>();
        TreeNode node = new TreeNode(Integer.parseInt(arr[0]));
        list.add(node);
        int index = 0;

        // ***********************从第一个开始
        for (int i = 1; i < arr.length; i++) {
            // 放入左右，并加入新的node到list
            if (!"#".equals(arr[i])) {
                // *****************************注意这里
                TreeNode treeNode = new TreeNode(Integer.parseInt(arr[i]));
                if (isLeft) {
                    list.get(index).left = treeNode;
                } else {
                    list.get(index).right = treeNode;
                }
                list.add(treeNode);
            }

            // 到了右边 该下一个根节点了
            if (!isLeft) {
                index++;
            }

            // 切换左右
            isLeft = !isLeft;
        }
        // 返回大根
        return list.get(0);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
