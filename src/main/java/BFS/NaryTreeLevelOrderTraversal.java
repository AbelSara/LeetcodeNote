package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Honghan Zhu
 * @leetcode 429
 * @grade medium
 */
public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resList = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        Node endNode = root;
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            level.add(curNode.val);
            queue.addAll(curNode.children);
            if (curNode == endNode) {
                resList.add(level);
                level = new ArrayList<>();
                if (!queue.isEmpty())
                    endNode = queue.getLast();
            }
        }
        return resList;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
