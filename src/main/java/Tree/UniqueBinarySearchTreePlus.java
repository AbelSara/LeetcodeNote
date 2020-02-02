package Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Honghan Zhu
 * @leetcode 95
 * @grade medium
 */
public class UniqueBinarySearchTreePlus {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> resList = generate(1, n);
        return resList;
    }

    private List<TreeNode> generate(int s, int e) {
        List<TreeNode> treeList = new LinkedList<>();
        if (s > e) {
            treeList.add(null);
            return treeList;
        }
        List<TreeNode> leftList;
        List<TreeNode> rightList;
        for (int i = s; i <= e; i++) {
            leftList = generate(s, i - 1);
            rightList = generate(i + 1, e);
            TreeNode root = new TreeNode(i);
            for (TreeNode leftNode : leftList) {
                for (TreeNode rightNode : rightList) {
                    root.left = leftNode;
                    root.right = rightNode;
                    treeList.add(root);
                    root = new TreeNode(i);
                }
            }
        }
        return treeList;
    }
}
