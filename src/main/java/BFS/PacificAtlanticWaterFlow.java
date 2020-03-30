package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Honghan Zhu
 * @leetcode 417
 * @grade medium
 */
public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if(matrix.length == 0)
            return new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int[][] arrived = new int[m][n];
        for (int i = 0; i < m; i++) {
            arrived[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            arrived[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            arrived[i][n - 1] = arrived[i][n - 1] == 1 || arrived[i][n - 1] == 3 ? 3 : 2;
        }
        for (int i = 0; i < n; i++) {
            arrived[m - 1][i] = arrived[m - 1][i] == 1 || arrived[m - 1][i] == 3 ? 3 : 2;
        }
        for (int i = 0; i < m; i++) {
            bfs(matrix, arrived, i, 0, m, n);
        }
        for (int i = 0; i < n; i++) {
            bfs(matrix, arrived, 0, i, m, n);
        }
        for (int i = 0; i < m; i++) {
            bfs(matrix, arrived, i, n - 1, m, n);
        }
        for (int i = 0; i < n; i++) {
            bfs(matrix, arrived, m - 1, i, m, n);
        }
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arrived[i][j] == 3) {
                    List<Integer> coor = new ArrayList<>();
                    coor.add(i);
                    coor.add(j);
                    resList.add(coor);
                }
            }
        }
        return resList;
    }

    private void bfs(int[][] matrix, int[][] arrived, int i, int j, int m, int n) {
        int arrive = arrived[i][j];
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            int x = coordinate[0], y = coordinate[1];
            if (x - 1 >= 0 && !visited[x - 1][y] && matrix[x - 1][y] >= matrix[x][y])
                mark(arrived, visited, x - 1, y, arrive, queue);
            if (x + 1 < m && !visited[x + 1][y] && matrix[x + 1][y] >= matrix[x][y])
                mark(arrived, visited, x + 1, y, arrive, queue);
            if (y - 1 >= 0 && !visited[x][y - 1] && matrix[x][y - 1] >= matrix[x][y])
                mark(arrived, visited, x, y - 1, arrive, queue);
            if (y + 1 < n && !visited[x][y + 1] && matrix[x][y + 1] >= matrix[x][y])
                mark(arrived, visited, x, y + 1, arrive, queue);
        }
    }

    private void mark(int[][] arrived, boolean[][] visited,
                      int x, int y, int arrive, LinkedList<int[]> queue) {
        if (arrived[x][y] == 0)
            arrived[x][y] = arrive;
        else if (arrived[x][y] == arrive)
            arrived[x][y] = arrive;
        else
            arrived[x][y] = 3;
        visited[x][y] = true;
        queue.offer(new int[]{x, y});
    }
}
