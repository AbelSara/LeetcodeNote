package Tree;

/**
 * @Author Honghan Zhu
 * @leetcode 543
 * @grade easy
 */
public class DiameterOfBinaryTree {
    int res;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        heightOfTree(root);
        return res;
    }

    private int heightOfTree(TreeNode root) {
        if (root == null)
            return 0;
        int heightOfLeft = heightOfTree(root.left);
        int heightOfRight = heightOfTree(root.right);
        res = Math.max(heightOfLeft + heightOfRight, res);
        return Math.max(heightOfLeft, heightOfRight) + 1;
    }
}
