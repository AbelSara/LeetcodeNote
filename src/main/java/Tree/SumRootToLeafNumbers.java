package Tree;

/**
 * @Author Honghan Zhu
 * @leetcode 129
 * @grade medium
 */
public class SumRootToLeafNumbers {
    int res;

    public int sumNumbers(TreeNode root) {
        res = 0;
        if(null != root)
            preorder(root, 0);
        return res;
    }

    private void preorder(TreeNode root,int sum){
        sum += root.val;
        if(null == root.left && null == root.right)
            res += sum;
        if(null != root.left)
            preorder(root.left, sum * 10);
        if(null != root.right)
            preorder(root.right, sum * 10);
    }
}
