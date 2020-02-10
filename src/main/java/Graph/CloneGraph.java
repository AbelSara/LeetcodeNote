package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Honghan Zhu
 * @leetcode 133
 * @grade medium
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node))
            return map.get(node);
        Node curNode = new Node(node.val);
        map.put(node, curNode);
        for (Node neighbor : node.neighbors) {
            curNode.neighbors.add(dfs(neighbor, map));
        }
        return curNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}