/**
 * Program: LeetCode
 * Description: Medium, 动态规划
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class UniquePathsII_63 {

    /**
     * 动态规划解法
     * 探究格子的规律可以达到，某个格子的路径数等于其左边和上边的和
     * 其实根据格子移动也可以得知，某个终点只能由左边或者上边过来，因此其路径数=左边数+上边数
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int arr[][] = new int[m][n];
        arr[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //确保上一格存在且不为障碍物
                if (i - 1 >= 0 && obstacleGrid[i - 1][j] != 1) {
                    arr[i][j] += arr[i - 1][j];
                }
                //确保左边存在且不为障碍物
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] != 1) {
                    arr[i][j] += arr[i][j - 1];
                }
            }
        }
        return arr[m - 1][n - 1];
    }


    public static void main(String[] args) {
        UniquePathsII_63 tc = new UniquePathsII_63();
    }
}
