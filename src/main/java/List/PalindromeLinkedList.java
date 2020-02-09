package List;

/**
 * @Author Honghan Zhu
 * @leetcode 234
 * @grade easy
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        int len = 0;
        for (ListNode p = head; p != null; p = p.next)
            len += 1;
        len = len / 2;
        ListNode p1 = head;
        for (int i = 1; i < len; i++) {
            head = head.next;
        }
        ListNode p2 = reverseList(head.next);
        head.next = null;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode resNode = new ListNode(0);
        resNode.next = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = resNode.next;
            resNode.next = head;
            head = tmp;
        }
        return resNode.next;
    }
}
