package List;

/**
 * @author Honghan Zhu
 * @leetcode 203
 * @grade easy
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (head != null) {
            if (head.val != val) {
                ListNode curNode = head.next;
                head.next = null;
                p.next = head;
                p = p.next;
                head = curNode;
            } else {
                head = head.next;
            }
        }
        return res.next;
    }
}
