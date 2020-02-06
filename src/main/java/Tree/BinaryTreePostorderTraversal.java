package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Honghan Zhu
 * @leetcode 145
 * @grade medium
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode r = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode p = stack.peek();
                if (p.right == r || p.right == null) {
                    r= stack.pop();
                    list.add(r.val);
                } else {
                    root = p.right;
                }
            }
        }
        return list;
    }
}
