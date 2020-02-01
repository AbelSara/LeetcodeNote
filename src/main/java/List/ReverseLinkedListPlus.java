package List;

/**
 * @Author Honghan Zhu
 * @leetcode 92
 * @grade medium
 */
public class ReverseLinkedListPlus {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode headList = new ListNode(0);
        ListNode tailList = new ListNode(0);
        int count = 1;
        ListNode p = headList;
        while (head != null && count < m) {
            ListNode tmpNode = head.next;
            p.next = head;
            head.next = null;
            head = tmpNode;
            p = p.next;
            count++;
        }
        while (head != null && count < n) {
            ListNode tmpNode = head.next;
            head.next = tailList.next;
            tailList.next = head;
            head = tmpNode;
            count++;
        }
        p.next = tailList.next;
        while (p.next != null) {
            p = p.next;
        }
        while (head != null) {
            ListNode tmpNode = head.next;
            p.next = head;
            head.next = null;
            head = tmpNode;
            p = p.next;
        }
        return headList.next;
    }
}
