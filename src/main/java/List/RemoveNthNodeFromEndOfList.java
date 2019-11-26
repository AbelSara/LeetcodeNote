package List;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n > 0) return null;
        int length = 0;
        for (ListNode tmp = head; tmp != null; tmp = tmp.next)
            ++length;
        if (length == n) return head.next;
        ListNode res = head;
        ListNode tail = head;
        for (int i = 0; i < n; i++) {
            tail = tail.next;
        }
        while (tail.next != null) {
            tail = tail.next;
            head = head.next;
        }
        head.next = head.next.next;
        return res;
    }
}
