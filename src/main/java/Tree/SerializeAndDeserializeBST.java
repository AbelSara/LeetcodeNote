package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Honghan Zhu
 * @leetcode 449
 * @grade medium
 */
public class SerializeAndDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        if (root == null)
            builder.append("null").append(',');
        else
            queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == -99) {
                builder.append("null").append(',');
                continue;
            }
            builder.append(node.val).append(',');
            if (node.left == null)
                queue.offer(new TreeNode(-99));
            else
                queue.offer(node.left);
            if (node.right == null)
                queue.offer(new TreeNode(-99));
            else
                queue.offer(node.right);
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        if (nodes[0].equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        int i = 1;
        queue.offer(root);
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode cur = queue.poll();
            if (nodes[i].equals("null"))
                cur.left = null;
            else {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodes[i]));
                cur.left = leftNode;
                queue.offer(leftNode);
            }
            i++;
            if (nodes[i].equals("null"))
                cur.right = null;
            else {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodes[i]));
                cur.right = rightNode;
                queue.offer(rightNode);
            }
            i++;
        }
        return root;
    }
}
