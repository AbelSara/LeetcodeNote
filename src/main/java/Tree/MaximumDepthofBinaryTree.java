package Tree;

/**
 * @author Honghan Zhu
 * @leetcode 104
 * @grade easy
 */
public class MaximumDepthofBinaryTree {
    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        preOrder(root, 0);
        return maxDepth;
    }

    private void preOrder(TreeNode root, int depth) {
        if (null == root) {
            maxDepth = maxDepth < depth ? depth : maxDepth;
            return;
        }
        preOrder(root.left, depth + 1);
        preOrder(root.right, depth + 1);
    }
}
