package Tree;

/**
 * @Author Honghan Zhu
 * @leetcode 226
 * @grade easy
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        revert(root);
        return root;
    }

    private void revert(TreeNode root) {
        if (root == null)
            return;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        revert(leftNode);
        revert(rightNode);
        root.left = rightNode;
        root.right = leftNode;
    }
}
