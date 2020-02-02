package Tree;

/**
 * @Author Honghan Zhu
 * @leetcode 98
 * @grade medium
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return isValid(root, Integer.MIN_VALUE, false, Integer.MAX_VALUE, false);
    }

    private boolean isValid(TreeNode root, int min, boolean minValid, int max, boolean maxValid) {
        if ((minValid && root.val <= min) || (maxValid && root.val >= max))
            return false;
        if (root.right == null && root.left == null) {
            return true;
        } else if (root.right == null && root.left.val < root.val) {
            return isValid(root.left, min, minValid, root.val, true);
        } else if (root.left == null && root.right.val > root.val) {
            return isValid(root.right, root.val, true, max, maxValid);
        } else if (root.right != null && root.left != null
                && root.left.val < root.val && root.right.val > root.val) {
            return isValid(root.left, min, minValid, root.val, true)
                    & isValid(root.right, root.val, true, max, maxValid);
        }
        return false;
    }
}
