package Tree;

/**
 * @Author Honghan Zhu
 * @leetcode 114
 * @grade medium
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        flatten(leftNode);
        flatten(rightNode);
        root.left = null;
        root.right = leftNode;
        TreeNode p = root;
        while (p.right != null)
            p = p.right;
        p.right = rightNode;
    }
}
