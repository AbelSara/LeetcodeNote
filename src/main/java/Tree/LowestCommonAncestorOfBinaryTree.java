package Tree;

import java.util.Stack;

/**
 * @Author Honghan Zhu
 * @leetcode 236
 * @grade medium
 */
public class LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode resNode = null;
        Stack<TreeNode> firstStack = postOrder(root, p);
        Stack<TreeNode> secondStack = postOrder(root, q);
        Stack<TreeNode> curveStack = new Stack<>();
        if (firstStack.size() > secondStack.size())
            curveStack = firstStack;
        else if (firstStack.size() < secondStack.size())
            curveStack = secondStack;
        if (!curveStack.isEmpty()) {
            int curveLen = Math.abs(firstStack.size() - secondStack.size());
            for (int i = 0; i < curveLen; i++)
                curveStack.pop();
        }
        while (!firstStack.isEmpty() && !secondStack.isEmpty()) {
            TreeNode f = firstStack.pop();
            TreeNode s = secondStack.pop();
            if (f == s) {
                resNode = f;
                break;
            }
        }
        return resNode;
    }

    private Stack postOrder(TreeNode root, TreeNode tar) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = root;
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.peek();
                if (p == tar)
                    break;
                if (p.right != null && pre != p.right) {
                    p = p.right;
                } else {
                    pre = stack.pop();
                    p = null;
                }
            }
        }
        return stack;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode leftNode = lowestCommonAncestor2(root.left, p, q);
        if (leftNode != null && leftNode != p && leftNode != q)
            return leftNode;
        TreeNode rightNode = lowestCommonAncestor2(root.right, p, q);
        if (rightNode != null && rightNode != p && rightNode != q)
            return rightNode;
        if (leftNode != null && rightNode != null)
            return root;
        return leftNode == null ? rightNode : leftNode;
    }
}
