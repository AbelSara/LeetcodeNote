package List;

/**
 * @author Honghan Zhu
 * @leetcode 876
 * @grade easy
 */
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, low = head;
        while (low != null && low.next != null) {
            fast = fast.next;
            low = low.next;
            if (low != null)
                low = low.next;
        }
        return fast;
    }
}
