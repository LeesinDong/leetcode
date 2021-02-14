/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
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
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                continue;
            }

            list.add(list.get(i).left);
            list.add(list.get(i).right);
        }

        while (list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }

        StringBuilder sb = new StringBuilder("{");
        sb.append(list.get(0).val);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == null) {
                sb.append(",").append("#");
            } else {
                sb.append(",").append(list.get(i).val);
            }
        }
        sb.append("}");

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || "{}".equals(data)) {
            return null;
        }

        String[] arr = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode node = new TreeNode(Integer.parseInt(arr[0]));
        queue.add(node);
        int index = 0;
        boolean isLeaf = true;

        for (int i = 1; i < arr.length; i++) {
            if (!"#".equals(arr[i])) {
                TreeNode treeNode = new TreeNode(Integer.parseInt(arr[i]));
                if (isLeaf) {
                    queue.get(index).left = treeNode;
                } else {
                    queue.get(index).right = treeNode;
                }
                queue.add(treeNode);
            }
            if (!isLeaf) {
                index++;
            }
            isLeaf = !isLeaf;
        }

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
