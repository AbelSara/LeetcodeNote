package Tree;

/**
 * @author Honghan Zhu
 * @leetcode 297
 * @grade hard
 */
public class SerializeAndDeserializeBinaryTree {
    int idx = 0;

    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        encode(root, builder);
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return decode(nodes);
    }

    private TreeNode decode(String[] nodes){
        if(nodes[idx].equals("null"))
            return null;
        TreeNode curNode = new TreeNode(Integer.parseInt(nodes[idx]));
        ++idx;
        curNode.left = decode(nodes);
        ++idx;
        curNode.right = decode(nodes);
        return curNode;
    }

    private void encode(TreeNode curNode, StringBuilder builder){
        if(curNode == null){
            builder.append("null").append(',');
            return;
        }
        builder.append(curNode.val).append(',');
        encode(curNode.left, builder);
        encode(curNode.right, builder);
    }
}
