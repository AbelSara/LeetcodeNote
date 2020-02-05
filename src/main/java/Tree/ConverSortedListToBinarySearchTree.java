package Tree;

import List.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Honghan Zhu
 * @leetcode 109
 * @grade medium
 */
public class ConverSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return generate(list, 0, list.size() - 1);
    }

    private TreeNode generate(List<Integer> list, int r, int l) {
        if (r > l) return null;
        int mid = (r + l) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = generate(list, r, mid - 1);
        root.right = generate(list, mid + 1, l);
        return root;
    }
}
