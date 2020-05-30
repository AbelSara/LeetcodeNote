package List;

/**
 * @author Honghan Zhu
 * @leetcode 430
 * @grade medium
 */
public class FlatteMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    Node res = new Node();
    Node p = res;

    public Node flatten(Node head) {
        if (head != null)
            flatt(head);
        res = res.next;
        if (res != null)
            res.prev = null;
        return res;
    }

    private void flatt(Node curNode) {
        p.next = curNode;
        curNode.prev = p;
        Node next = curNode.next;
        curNode.next = null;
        Node child = curNode.child;
        curNode.child = null;
        p = p.next;
        if (child != null)
            flatt(child);
        if (next != null)
            flatt(next);
    }
}
