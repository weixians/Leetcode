import java.util.HashSet;
import java.util.Set;

/**
 * Program: LeetCode
 * Description: Medium
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class SetMatrixZeros_73 {
    /**
     * 使用两个set记录要置零的行和列
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int row : rows) {
            for (int i = 0; i < n; i++) {
                matrix[row][i] = 0;
            }
        }
        for (int col : cols) {
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }
    }

    /**
     * 5ms
     *
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean rowZero = false, lastRowZero = false;
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //如果当前元素为0，将该列好加入set中，并标志该行要为0，方便遍历下一行时，将该行置为0
                if (matrix[i][j] == 0) {
                    cols.add(j);
                    rowZero = true;
                }
                if (cols.contains(j)) {
                    for (int k = 0; k <= i; k++) {
                        matrix[k][j] = 0;
                    }
                }
                if (lastRowZero) {
                    matrix[i - 1][j] = 0;
                }
            }
            lastRowZero = rowZero;
            rowZero = false;
        }
        //处理最后一行
        if (lastRowZero) {
            for (int i = 0; i < n; i++) {
                matrix[m - 1][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeros_73 tc = new SetMatrixZeros_73();

    }
}
