package List;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Honghan Zhu
 * @leetcode 143
 * @grade medium
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null) return;
        List<ListNode> list = new ArrayList<>();
        for (ListNode p = head; p != null; p = p.next) {
            list.add(p);
        }
        ListNode p = head;
        for (int i = 1, j = list.size() - 1; i < j; ) {
            if (i < j) {
                p.next = list.get(j--);
                p = p.next;
            }
            if (i < j) {
                p.next = list.get(i++);
                p = p.next;
            }
        }
        p.next = null;
    }
}
