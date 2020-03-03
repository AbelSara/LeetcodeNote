package Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Honghan Zhu
 * @leetcode 257
 * @grade easy
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if(root != null)
            order(res, new StringBuilder(), root);
        return res;
    }

    private void order(List<String> res, StringBuilder builder, TreeNode root){
        builder.append(root.val);
        if(root.left == root.right){
            res.add(builder.toString());
        }
        builder.append("->");
        if(root.left != null)
            order(res, builder, root.left);
        if(root.right != null)
            order(res, builder, root.right);
        builder.delete(builder.length() - 3, builder.length());
    }
}
