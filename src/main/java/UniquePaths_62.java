/**
 * Program: LeetCode
 * Description: Medium, 动态规划
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class UniquePaths_62 {

    /**
     * 动态规划解法
     * 探究格子的规律可以达到，某个格子的路径数等于其左边和上边的和
     * 其实根据格子移动也可以得知，某个终点只能由左边或者上边过来，因此其路径数=左边数+上边数
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int arr[][] = new int[m][n];
        arr[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //确保上一行存在
                if (i - 1 >= 0) {
                    arr[i][j] += arr[i - 1][j];
                }
                //确保左边存在
                if (j - 1 >= 0) {
                    arr[i][j] += arr[i][j - 1];
                }
            }
        }
        return arr[m - 1][n - 1];
    }


    public static void main(String[] args) {
        UniquePaths_62 tc = new UniquePaths_62();
//        System.out.println(tc.uniquePaths(51, 9));
//        for (int i = 1; i < 10; i++) {
//            tc = new UniquePaths_62();
//            System.out.println(tc.uniquePaths(51, i));
//        }
        System.out.println(tc.uniquePaths(3, 2));
        tc = new UniquePaths_62();
        System.out.println(tc.uniquePaths(7, 3));
    }
}
