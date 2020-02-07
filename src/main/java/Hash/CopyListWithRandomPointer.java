package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Honghan Zhu
 * @leetcode 138
 * @grade medium
 */
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node res = new Node(0);
        for(Node p = head, t = res; p != null; p = p.next){
            Node curNode = new Node(p.val);
            t.next = curNode;
            t = t.next;
            map.put(p, curNode);
        }
        for(Node p = head, t = res.next; p != null; p = p.next, t = t.next){
            if(p.random == null)
                t.random = null;
            else
                t.random = map.get(p.random);
        }
        return res.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}