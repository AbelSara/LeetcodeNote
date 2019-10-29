package Tree;

/**
 * @author Honghan Zhu
 * @leetcode 101
 * @grade easy
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return order(root, root);
    }

    private boolean order(TreeNode p, TreeNode q) {
        if (null == p && null == q)
            return true;
        else if (null == p || null == q)
            return false;
        else if (p.val != q.val)
            return false;
        if (!order(p.left, q.right))
            return false;
        if (!order(p.right, q.left))
            return false;
        return p.val == q.val;
    }
}
