package DFS;

/**
 * @author Honghan Zhu
 * @leetcode 1162
 * @grade medium
 */
public class AsFarFromLandAsPossibleWithDFS {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 0, 0},
                {0, 0, 0},
                {1, 0, 0}
        };
        new AsFarFromLandAsPossibleWithDFS().maxDistance(grid);
    }

    public int maxDistance(int[][] grid) {
        if (grid.length == 0)
            return -1;
        int m = grid.length, n = grid[0].length;
        int[][] distances = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    dfs(grid, distances, visited, i, j, m, n, 0);
            }
        }
        int res = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (distances[i][j] != 0)
                    res = Math.max(res, distances[i][j]);
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int[][] distances, boolean[][] visited,
                     int i, int j, int m, int n, int steps) {
        if (i < 0 || j < 0 || i == m || j == n ||
                (grid[i][j] == 1 && steps != 0) || visited[i][j] || steps >= distances[i][j])
            return;
        if (distances[i][j] == 0 || steps < distances[i][j])
            distances[i][j] = steps;
        visited[i][j] = true;
        dfs(grid, distances, visited, i - 1, j, m, n, steps + 1);
        dfs(grid, distances, visited, i + 1, j, m, n, steps + 1);
        dfs(grid, distances, visited, i, j - 1, m, n, steps + 1);
        dfs(grid, distances, visited, i, j + 1, m, n, steps + 1);
        visited[i][j] = false;
    }
}
