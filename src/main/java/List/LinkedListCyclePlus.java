package List;

/**
 * @Author Honghan Zhu
 * @leetcode 142
 * @grade medium
 */
public class LinkedListCyclePlus {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, low = head;
        while (fast != null && low != null) {
            low = low.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
            if (fast == low)
                break;
        }
        if (fast == null || low == null)
            return null;
        while (fast != head) {
            fast = fast.next;
            head = head.next;
        }
        return head;
    }
}
