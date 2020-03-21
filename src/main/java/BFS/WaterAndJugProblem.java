package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Honghan Zhu
 * @leetcode 365
 * @grade medium
 */
public class WaterAndJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        Set<Pair> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            System.out.println(pair.first + " " + pair.second);
            visited.add(pair);
            if (pair.first == z || pair.second == z || pair.first + pair.second == z)
                return true;
            Pair cur;
            if (pair.first == 0) {
                cur = new Pair(x, pair.second);
                if (!visited.contains(cur) && !queue.contains(cur))
                    queue.offer(cur);
            }
            if (pair.second == 0) {
                cur = new Pair(pair.first, y);
                if (!visited.contains(cur) && !queue.contains(cur))
                    queue.offer(cur);
            }
            if (pair.first <= x) {
                cur = new Pair(0, pair.second);
                if (!visited.contains(cur) && !queue.contains(cur))
                    queue.offer(cur);
            }
            if (pair.second <= y) {
                cur = new Pair(pair.first, 0);
                if (!visited.contains(cur) && !queue.contains(cur))
                    queue.offer(cur);
            }
            int move = Math.min(pair.first, y - pair.second);
            cur = new Pair(pair.first - move, pair.second + move);
            if (!visited.contains(cur) && !queue.contains(cur))
                queue.offer(cur);
            move = Math.min(x - pair.first, pair.second);
            cur = new Pair(pair.first + move, pair.second - move);
            if (!visited.contains(cur) && !queue.contains(cur))
                queue.offer(cur);
        }
        return false;
    }

    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != pair.first) return false;
            return second == pair.second;
        }

        @Override
        public int hashCode() {
            String code = first + " " + second;
            return code.hashCode();
        }
    }
}
