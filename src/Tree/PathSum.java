package Tree;

/**
 * @author: Honghan Zhu
 * @leetcode: 112
 * @grade: easy
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }
        return preOrder(root, 0, sum);
    }

    private boolean preOrder(TreeNode p, int sum, int target) {
        sum += p.val;
        if (null != p.left) {
            if (preOrder(p.left, sum, target)) return true;
        }
        if (null != p.right) {
            if (preOrder(p.right, sum, target)) return true;
        }
        if (null == p.left && null == p.right && sum == target) return true;
        return false;
    }
}
