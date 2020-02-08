package Design;

import Tree.TreeNode;

import java.util.Stack;

/**
 * @Author Honghan Zhu
 * @leetcode 173
 * @grade medium
 */
public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        int val = node.val;
        node = node.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
