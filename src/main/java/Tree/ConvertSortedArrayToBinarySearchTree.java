package Tree;

/**
 * @author Honghan Zhu
 * @leetcode 108
 * @grade easy
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        else if (nums.length == 1) return new TreeNode(nums[0]);
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (mid - 1 >= 0) {
            root.left = new TreeNode(-1);
            trans(nums, 0, mid - 1, root.left);
        }
        if (nums.length - 1 >= mid + 1) {
            root.right = new TreeNode(-1);
            trans(nums, mid + 1, nums.length - 1, root.right);
        }
        return root;
    }

    private void trans(int[] nums, int left, int right, TreeNode root) {
        if (left > right) return;
        int mid = (left + right) / 2;
        root.val = nums[mid];
        if (mid - 1 >= left) {
            root.left=new TreeNode(-1);
            trans(nums, left, mid - 1, root.left);
        }
        if (right >= mid + 1) {
            root.right=new TreeNode(-1);
            trans(nums, mid + 1, right, root.right);
        }
    }
}
