package Arrays;

/**
 * @author Honghan Zhu
 * @leetcode 892
 * @grade easy
 */
public class SurfacAreaOf3DShape {
    public int surfaceArea(int[][] grid) {
        if(grid.length == 0)
            return 0;
        int res = 0, m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0)
                    continue;
                int area = 6 + (grid[i][j] - 1) * 4;
                if(i - 1 >= 0)
                    area -= Math.min(grid[i - 1][j], grid[i][j]);
                if(i + 1 < m)
                    area -= Math.min(grid[i + 1][j], grid[i][j]);
                if(j - 1 >= 0)
                    area -= Math.min(grid[i][j - 1], grid[i][j]);
                if(j + 1 < n)
                    area -= Math.min(grid[i][j + 1], grid[i][j]);
                res += area;
            }
        }
        return res;
    }
}
