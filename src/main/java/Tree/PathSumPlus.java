package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Honghan Zhu
 * @leetcode 113
 * @grade medium
 */
public class PathSumPlus {
    List<List<Integer>> resList;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        resList = new ArrayList<>();
        if (root != null) preorder(root, sum, 0, new LinkedList<>());
        return resList;
    }

    private void preorder(TreeNode root, int target, int sum, LinkedList<Integer> list) {
        sum += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null && sum == target) {
            resList.add(new LinkedList<>(list));
        }
        if (root.left != null)
            preorder(root.left, target, sum, list);
        if (root.right != null)
            preorder(root.right, target, sum, list);
        list.removeLast();
    }
}
