package List;

/**
 * @author: Honghan Zhu
 * @leetcode: 141
 * @grade: easy
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode low = head, high = head;
        while (null != low && null != high) {
            if (null != low) {
                low = low.next;
            }
            for (int i = 0; i < 2 && null != high; i++) {
                high = high.next;
            }
            if (low == high && null != low) {
                return true;
            }
        }
        return false;
    }
}
