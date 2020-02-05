package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Honghan Zhu
 * @leetcode 103
 * @grade medium
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (null == root) return resList;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode endNode = root;
        stack.add(root);
        int flag = 0;
        Stack<TreeNode> tmpStack = new Stack<>();
        while (!stack.isEmpty()) {
            TreeNode tmpNode = stack.pop();
            list.add(tmpNode.val);
            if (flag == 0) {
                if (tmpNode.left != null)
                    tmpStack.push(tmpNode.left);
                if (tmpNode.right != null)
                    tmpStack.push(tmpNode.right);
            } else {
                if (tmpNode.right != null)
                    tmpStack.push(tmpNode.right);
                if (tmpNode.left != null)
                    tmpStack.push(tmpNode.left);
            }
            if (endNode == tmpNode) {
                resList.add(list);
                if (tmpStack.isEmpty()) break;
                endNode = tmpStack.firstElement();
                list = new ArrayList<>();
                flag = flag == 0 ? 1 : 0;
                stack = tmpStack;
                tmpStack = new Stack<>();
            }
        }
        return resList;
    }
}
