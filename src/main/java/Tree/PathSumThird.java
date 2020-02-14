package Tree;


/**
 * @Author Honghan Zhu
 * @leetcode 437
 * @grade easy
 */
public class PathSumThird {
    int res = 0;

    public int pathSum(TreeNode root, int sum) {
        preorder(root, sum, new int[1000], 0);
        return res;
    }

    private void preorder(TreeNode root, int target, int[] array, int idx) {
        if (root == null)
            return;
        array[idx] = root.val;
        int sum = 0;
        for (int i = idx; i >= 0; i--) {
            sum += array[i];
            if (sum == target)
                res += 1;
        }
        preorder(root.left, target, array, idx + 1);
        preorder(root.right, target, array, idx + 1);
    }
}
