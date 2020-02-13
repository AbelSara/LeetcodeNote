package Tree;

/**
 * @Author Honghan Zhu
 * @leetcode 538
 * @grade easy
 */
public class ConvertBSTGreaterTree {
    int val;

    public TreeNode convertBST(TreeNode root) {
        val = 0;
        reverseInorder(root);
        return root;
    }

    private void reverseInorder(TreeNode root){
        if(null == root)
            return;
        reverseInorder(root.right);
        root.val += val;
        val = root.val;
        reverseInorder(root.left);
    }
}
