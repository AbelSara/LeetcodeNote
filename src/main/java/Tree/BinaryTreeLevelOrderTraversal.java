package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Honghan Zhu
 * @leetcode 102
 * @grade medium
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if(null == root) return resList;
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode endNode = root;
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode tmpNode = queue.removeFirst();
            list.add(tmpNode.val);
            if (tmpNode.left != null)
                queue.add(tmpNode.left);
            if (tmpNode.right != null)
                queue.add(tmpNode.right);
            if (tmpNode == endNode) {
                resList.add(list);
                if (queue.isEmpty()) break;
                list = new ArrayList<>();
                endNode = queue.getLast();
            }
        }
        return resList;
    }
}
