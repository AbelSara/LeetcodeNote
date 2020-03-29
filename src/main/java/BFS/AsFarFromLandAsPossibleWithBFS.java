package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Honghan Zhu
 * @leetcode 1162
 * @grade medium
 */
public class AsFarFromLandAsPossibleWithBFS {
    public int maxDistance(int[][] grid) {
        if (grid.length == 0)
            return -1;
        int m = grid.length, n = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        int res = -1;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair.dis != 0 && pair.dis > res)
                res = pair.dis;
            if (pair.x - 1 >= 0 && !visited[pair.x - 1][pair.y]) {
                visited[pair.x - 1][pair.y] = true;
                queue.offer(new Pair(pair.x - 1, pair.y, pair.dis + 1));
            }
            if (pair.x + 1 < m && !visited[pair.x + 1][pair.y]) {
                visited[pair.x + 1][pair.y] = true;
                queue.offer(new Pair(pair.x + 1, pair.y, pair.dis + 1));
            }
            if (pair.y - 1 >= 0 && !visited[pair.x][pair.y - 1]) {
                visited[pair.x][pair.y - 1] = true;
                queue.offer(new Pair(pair.x, pair.y - 1, pair.dis + 1));
            }
            if (pair.y + 1 < n && !visited[pair.x][pair.y + 1]) {
                visited[pair.x][pair.y + 1] = true;
                queue.offer(new Pair(pair.x, pair.y + 1, pair.dis + 1));
            }
        }

        return res;
    }

    class Pair {
        int x, y, dis;

        Pair(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}
