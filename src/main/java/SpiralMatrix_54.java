import java.util.ArrayList;
import java.util.List;

/**
 * Program: LeetCode
 * Description: Medium
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class SpiralMatrix_54 {
    /**
     * 螺旋遍历，不断更新上下左右的边界值
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;
        int count = 0;
        int len = m * n;
        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
                count++;
                if (count >= len) {
                    return res;
                }
            }
            top += 1;

            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
                count++;
                if (count >= len) {
                    return res;
                }
            }
            right -= 1;
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
                count++;
                if (count >= len) {
                    return res;
                }
            }
            bottom -= 1;
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
                count++;
                if (count >= len) {
                    return res;
                }
            }
            left += 1;
        }
    }

    public static void main(String[] args) {
        SpiralMatrix_54 tc = new SpiralMatrix_54();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(tc.spiralOrder(matrix));
    }
}
