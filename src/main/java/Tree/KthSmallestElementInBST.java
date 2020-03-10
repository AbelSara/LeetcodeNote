package Tree;

/**
 * @author Honghan Zhu
 * @leetcode 230
 * @grade medium
 */
public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        int countsOfLeftTree = countsOfTree(root.left);
        if (countsOfLeftTree == k - 1)
            return root.val;
        if (countsOfLeftTree >= k)
            return kthSmallest(root.left, k);
        else
            return kthSmallest(root.right, k - countsOfLeftTree - 1);
    }

    private int countsOfTree(TreeNode root) {
        if (root == null)
            return 0;
        int countsOfLeftTree = countsOfTree(root.left);
        int countsOfRightTree = countsOfTree(root.right);
        int counts = countsOfLeftTree + countsOfRightTree + 1;
        return counts;
    }
}
