package Tree;

/**
 * @author Honghan Zhu
 * @leetcode 404
 * @grade easy
 */
public class SumOfLeftLeaves {
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        order(root, 0);
        return sum;
    }

    private void order(TreeNode root, int flag) {
        if (root == null)
            return;
        if (root.left == null && root.right == null && flag == 1)
            sum += root.val;
        order(root.left, 1);
        order(root.right, 2);
    }
}
