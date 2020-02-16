package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Honghan Zhu
 * @leetcode 337
 * @grade medium
 */
public class HouseRobberThird {
    Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        if (map.containsKey(root))
            return map.get(root);
        int selfSum = root.val;
        int childSum = 0;
        if (root.left != null) {
            childSum += rob(root.left);
            selfSum += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            childSum += rob(root.right);
            selfSum += rob(root.right.left) + rob(root.right.right);
        }
        int val = Math.max(childSum, selfSum);
        map.put(root, val);
        return val;
    }
}
