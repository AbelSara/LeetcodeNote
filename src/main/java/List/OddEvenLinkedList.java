package List;

/**
 * @author Honghan Zhu
 * @leetcode 328
 * @grade medium
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode po = odd, pe = even;
        for (int i = 1; head != null; i++) {
            ListNode tmp = head.next;
            if (i % 2 == 0) {
                pe.next = head;
                head.next = null;
                pe = pe.next;
            } else {
                po.next = head;
                head.next = null;
                po = po.next;
            }
            head = tmp;
        }
        po.next = even.next;
        return odd.next;
    }
}
