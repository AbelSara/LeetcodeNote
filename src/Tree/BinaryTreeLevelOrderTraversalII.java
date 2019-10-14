package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author:Honghan Zhu
 * leetcode:107
 * Grade:easy
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (null == root) return new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        TreeNode p=root, end = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> levelOrder = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            levelOrder.add(temp.val);
            if (null != temp.left) {
                queue.offer(temp.left);
                p = temp.left;
            }
            if (null != temp.right) {
                queue.offer(temp.right);
                p = temp.right;
            }
            if (temp == end) {
                result.add(0, levelOrder);
                levelOrder = new LinkedList<>();
                end = p;
            }
        }
        return result;
    }
}
