package Tree;

import java.util.LinkedList;

/**
 * @Author Honghan Zhu
 * @leetcode 116
 * @grade medium
 */
public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null)
            return root;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        Node endNode = root;
        Node preNode = null;
        Node curNode = null;
        while (!queue.isEmpty()) {
            curNode = queue.removeFirst();
            if (preNode != null)
                preNode.next = curNode;
            preNode = curNode;
            if (curNode.left != null)
                queue.add(curNode.left);
            if (curNode.right != null)
                queue.add(curNode.right);
            if (endNode == curNode && !queue.isEmpty()) {
                curNode.next = null;
                preNode = null;
                endNode = queue.getLast();
            }
        }
        return root;
    }

    public Node connect2(Node root) {
        if (root == null)
            return root;
        Node p = root;
        while (p != null) {
            Node pre = null;
            Node cur = p;
            Node next = null;
            while (cur != null) {
                Node left = cur.left;
                Node right = cur.right;
                if (next == null) {
                    if (left != null)
                        next = left;
                    else if (right != null)
                        next = right;
                }
                if (pre != null) {
                    if (left != null && right == null) {
                        pre.next = left;
                        pre = left;
                    } else if (right != null && left == null) {
                        pre.next = right;
                        pre = right;
                    } else if (right != null && left != null) {
                        pre.next = left;
                        left.next = right;
                        pre = right;
                    }
                } else {
                    if (left != null && right == null)
                        pre = left;
                    else if (left == null && right != null)
                        pre = right;
                    else if (left != null && right != null) {
                        left.next = right;
                        pre = right;
                    }
                }
                cur = cur.next;
            }
            if (pre != null)
                pre.next = null;
            p = next;
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};