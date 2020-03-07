package Tree;

/**
 * @author Honghan Zhu
 * @leetcode 235
 * @grade easy
 */
public class LowestCommonAncestorOfBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode tmp = q;
            q = p;
            p = tmp;
        }
        return foundAncestor(root, p, q);
    }

    private TreeNode foundAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((p.val < root.val && q.val > root.val) || p == root || q == root)
            return root;
        else if (p.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else if (q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        return null;
    }
}
