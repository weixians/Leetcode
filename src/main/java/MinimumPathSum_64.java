/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class MinimumPathSum_64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0 || j - 1 >= 0) {
                    if (i - 1 < 0) {
                        //上面为空
                        grid[i][j] += grid[i][j - 1];
                    } else if (j - 1 < 0) {
                        //左边为空
                        grid[i][j] += grid[i - 1][j];
                    } else {
                        //上面和左边都不为空
                        grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                    }
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum_64 tc = new MinimumPathSum_64();

    }
}
