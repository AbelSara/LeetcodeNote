package Tree;

/**
 * @author Honghan Zhu
 * @leetcode 111
 * @grade easy
 */
public class MinimumDepthOfBinaryTree {
    int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        preOrder(root, 1);
        return minDepth;
    }

    private void preOrder(TreeNode root, int depth) {
        if (null == root) {
            return;
        }
        if (null == root.left && null == root.right) {
            minDepth = depth < minDepth ? depth : minDepth;
        }
        preOrder(root.left, 1 + depth);
        preOrder(root.right, 1 + depth);
    }
}
