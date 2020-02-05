package List;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Honghan Zhu
 * @leetcode 1019
 * @grade medium
 */
public class NextGreatNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < list.size(); i++) {
            int val = list.get(i);
            int preIdx = stack.peek();
            while (val > list.get(preIdx)) {
                res[stack.pop()] = val;
                if (stack.isEmpty()) {
                    break;
                }
                preIdx = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
}
