package BFS;

/**
 * @Author Honghan Zhu
 * @leetcode 200
 * @grade medium
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid.length == 0) return res;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res += 1;
                    bfs(grid, visited, i, j, m, n);
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, boolean[][] visited, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == '0')
            return;
        visited[i][j] = true;
        bfs(grid, visited, i + 1, j, m, n);
        bfs(grid, visited, i - 1, j, m, n);
        bfs(grid, visited, i, j + 1, m, n);
        bfs(grid, visited, i, j - 1, m, n);
    }
}
