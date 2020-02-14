package Graph;

import java.util.*;

/**
 * @Author Honghan Zhu
 * @leetcode 399
 * @grade medium
 */
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            if (!map.containsKey(a))
                map.put(a, new HashMap<>());
            if (!map.containsKey(b))
                map.put(b, new HashMap<>());
            map.get(a).put(b, values[i]);
            map.get(b).put(a, 1.0 / values[i]);
        }
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String a = query.get(0);
            String b = query.get(1);
            res[i] = dfs(map, new HashSet<String>(), 1.0, a, b);
        }
        return res;
    }

    private double dfs(Map<String, Map<String, Double>> map, Set<String> visited, double num, String a, String b) {
        if(!(map.containsKey(a) && map.containsKey(b)))
            return -1.0;
        Map<String, Double> curMap = map.get(a);
        for (Map.Entry<String, Double> entry : curMap.entrySet()) {
            String key = entry.getKey();
            double val = entry.getValue() * num;
            if (visited.contains(key))
                continue;
            if (b.equals(key))
                return val;
            visited.add(key);
            double res = dfs(map, visited, val, key, b);
            if (res != -1.0)
                return res;
            visited.remove(key);
        }
        return -1.0;
    }
}
