/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class RotateImage {
    //保存某个数要替换的未来位置
    int[] futurePos = new int[2];

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix.length - 1 - i; j++) {
                int next = matrix[i][j];
                futurePos[0] = i;
                futurePos[1] = j;
                do {
                    next = replace(matrix, next, n);
                } while (futurePos[0] != i || futurePos[1] != j);
            }
        }
    }

    private int replace(int[][] matrix, int num, int n) {
        computeFuturePos(n, futurePos[0], futurePos[1]);
        int next = matrix[futurePos[0]][futurePos[1]];
        matrix[futurePos[0]][futurePos[1]] = num;
        return next;
    }

    private void computeFuturePos(int rowLen, int i, int j) {
        //原来的纵坐标是替换后元素的横坐标
        futurePos[0] = j;
        //原来的横坐标与替换后元素的纵坐标相加为len-1
        futurePos[1] = rowLen - 1 - i;
    }

    public static void main(String[] args) {
        RotateImage tc = new RotateImage();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        tc.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
