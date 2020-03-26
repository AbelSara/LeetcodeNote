package DFS;

import java.util.*;

/**
 * @author Honghan Zhu
 * @leetcode 332
 * @grade medium
 */
public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, LinkedList<String>> table = new HashMap<>();
        for (List<String> ticket : tickets) {
            String start = ticket.get(0);
            String end = ticket.get(1);
            if (!table.containsKey(start))
                table.put(start, new LinkedList<>());
            LinkedList<String> ends = table.get(start);
            ends.add(end);
        }
        table.entrySet().stream().forEach(e -> Collections.sort(e.getValue()));
        LinkedList<String> res = new LinkedList<>();
        dfs(table, "JFK", res);
        return res;
    }

    private void dfs(Map<String, LinkedList<String>> table, String start, LinkedList<String> res) {
        LinkedList<String> curList = table.get(start);
        while (curList != null && curList.size() > 0) {
            String next = curList.removeFirst();
            dfs(table, next, res);
        }
        res.addFirst(start);
    }
}
