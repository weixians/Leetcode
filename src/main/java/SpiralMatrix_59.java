import java.util.ArrayList;
import java.util.List;

/**
 * Program: LeetCode
 * Description: Medium
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class SpiralMatrix_59 {
    public int[][] generateMatrix(int n) {
        int len = n * n;
        int[][] matrix = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int count = 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = count;
                count++;
                if (count > len) {
                    return matrix;
                }
            }
            top += 1;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = count;
                count++;
                if (count > len) {
                    return matrix;
                }
            }
            right -= 1;
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = count;
                count++;
                if (count > len) {
                    return matrix;
                }
            }
            bottom -= 1;
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = count;
                count++;
                if (count > len) {
                    return matrix;
                }
            }
            left += 1;
        }
    }

    public static void main(String[] args) {
        SpiralMatrix_59 tc = new SpiralMatrix_59();
        int n = 3;
        int[][] matrix = tc.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
