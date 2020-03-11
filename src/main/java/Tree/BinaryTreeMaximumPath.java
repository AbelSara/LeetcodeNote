package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Honghan Zhu
 * @leetcode 124
 * @grade hard
 */
public class BinaryTreeMaximumPath {
    Map<TreeNode, Integer> map = new HashMap<>();

    public int maxPathSum(TreeNode root) {
        if(root.left == null && root.right == null)
            return root.val;
        int leftMaximum = root.left == null ? Integer.MIN_VALUE : maxPathSum(root.left);
        int rightMaximum = root.right == null ? Integer.MIN_VALUE : maxPathSum(root.right);
        int leftSeries = Math.max(series(root.left), 0);
        int rightSeries = Math.max(series(root.right), 0);
        return Math.max(leftSeries + rightSeries + root.val,
                Math.max(leftMaximum, rightMaximum));
    }

    private int series(TreeNode root) {
        if (root == null)
            return 0;
        if(map.containsKey(root))
            return map.get(root);
        int leftSeries = Math.max(series(root.left), 0);
        int rightSeries = Math.max(series(root.right), 0);
        int res = Math.max(rightSeries + root.val, leftSeries + root.val);
        map.put(root, res);
        return res;
    }
}
