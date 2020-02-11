package List;

/**
 * @Author Honghan Zhu
 * @leetcode 25
 * @grade hard
 */
public class ReverseNodeInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode resNode = new ListNode(0);
        ListNode p = resNode;
        while (canReverse(head, k)) {
            ListNode tailNode = head;
            for (int i = 0; i < k; i++) {
                ListNode tmpNode = head.next;
                head.next = p.next;
                p.next = head;
                head = tmpNode;
            }
            p = tailNode;
        }
        p.next = head;
        return resNode.next;
    }

    private boolean canReverse(ListNode head, int k) {
        for (int i = 0; i < k; i++) {
            if (head == null)
                return false;
            head = head.next;
        }
        return true;
    }
}
