package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Honghan Zhu
 * @leecode 105
 * @grade medium
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe)
            return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int tar = map.get(root.val);
        root.left = build(preorder, ps + 1, ps + tar - is, inorder, is, tar - 1);
        root.right = build(preorder, ps + tar - is + 1, pe, inorder, tar + 1, ie);
        return root;
    }
}
