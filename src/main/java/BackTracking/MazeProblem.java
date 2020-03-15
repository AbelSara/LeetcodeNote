package BackTracking;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Honghan Zhu
 * @newcoder
 */
public class MazeProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] map = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            LinkedList<Entry> res = new LinkedList<>();
            backtrack(0, 0, m, n, map, new boolean[m][n], new LinkedList<>(), res);
            for (Entry re : res) {
                System.out.println("(" + re.rowIdx + "," + re.colIdx + ")");
            }
        }
    }

    private static void backtrack(int i, int j, int m, int n, int[][] map, boolean[][] visited,
                                  LinkedList<Entry> list, LinkedList<Entry> resList) {
        if (i < 0 || i >= m || j < 0 || j >= n || map[i][j] == 1 || visited[i][j])
            return;
        list.add(new Entry(i, j));
        visited[i][j] = true;
        if (i + 1 == m && j + 1 == n || (resList.isEmpty() || list.size() < resList.size())) {
            resList.clear();
            resList.addAll(list);
        }
        backtrack(i - 1, j, m, n, map, visited, list, resList);
        backtrack(i + 1, j, m, n, map, visited, list, resList);
        backtrack(i, j - 1, m, n, map, visited, list, resList);
        backtrack(i, j + 1, m, n, map, visited, list, resList);
        visited[i][j] = false;
        list.removeLast();
    }

    static class Entry {
        int rowIdx;
        int colIdx;

        public Entry(int rowIdx, int colIdx) {
            this.rowIdx = rowIdx;
            this.colIdx = colIdx;
        }
    }
}
