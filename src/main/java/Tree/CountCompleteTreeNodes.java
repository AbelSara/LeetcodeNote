package Tree;

/**
 * @author Honghan Zhu
 * @leetcode 222
 * @grade medium
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int heightOfLeftTree = countHeight(root.left);
        int heightOfRightTree = countHeight(root.right);
        int count = 0;
        if (heightOfLeftTree == heightOfRightTree) {
            count = countNodes(root.right) + (int) Math.pow(2, heightOfLeftTree) - 1;
        } else {
            count = countNodes(root.left) + (int) Math.pow(2, heightOfRightTree) - 1;
        }
        return count;
    }

    private int countHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height += 1;
        }
        return height;
    }
}
