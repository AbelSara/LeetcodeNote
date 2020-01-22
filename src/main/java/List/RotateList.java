package List;

/**
 * @Author Honghan Zhu
 * @leetcode 61
 * @grade medium
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        int length = 0;
        ListNode lastNode = null;
        for (ListNode node = head; node != null; node = node.next) {
            lastNode = node;
            length++;
        }
        k = k % length;
        if (k == 0)
            return head;
        ListNode res = new ListNode(0);
        ListNode tmpNode = head;
        for (int i = 0; i < length - k - 1; i++) {
            tmpNode = tmpNode.next;
        }
        if (lastNode == tmpNode) {
            res.next = tmpNode;
        } else {
            res.next = tmpNode.next;
            tmpNode.next = null;
            lastNode.next = head;
        }
        return res.next;
    }
}
