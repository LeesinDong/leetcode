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
        // {1,2,3,#,#,4,5}
        StringBuilder sb = new StringBuilder("{");
        sb.append(list.get(0).val);
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
        boolean isLeft = true;
        // 为什么不能是queue，因为下面的某个要重复的用
        List<TreeNode> queue = new ArrayList<>();
        TreeNode node = new TreeNode(Integer.parseInt(arr[0]));
        queue.add(node);
        int index = 0;

        for (int i = 1; i < arr.length; i++) {
            if (!"#".equals(arr[i])) {
                TreeNode treeNode = new TreeNode(Integer.parseInt(arr[i]));
                if (isLeft) {
                    queue.get(index).left = treeNode;
                } else {
                    queue.get(index).right = treeNode;
                }
                queue.add(treeNode);
            }

            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        return queue.get(0);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
