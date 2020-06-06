/**
 * Program: LeetCode
 * Description: Medium
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class SearchA2dMatrix_74 {
    private boolean find = false;

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        for (int i = 0; i < matrix.length - 1; i++) {
            if (target >= matrix[i][0] && target < matrix[i + 1][0]) {
                row = i;
                break;
            } else if (target >= matrix[i + 1][0]) {
                row = i + 1;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (target == matrix[row][i]) {
                return true;
            }
        }
        search(matrix[row], 0, matrix[0].length, target);
        return find;
    }

    /**
     * 二分搜索
     *
     * @param nums
     * @param left
     * @param right
     * @param target
     */
    private void search(int[] nums, int left, int right, int target) {
        if (right - left <= 1) {
            find = target == nums[left];
            return;
        }
        int pivot = (left + right) / 2;
        if (target == nums[pivot]) {
            find = true;
        } else if (target < nums[pivot]) {
            search(nums, left, pivot, target);
        } else {
            search(nums, pivot, right, target);
        }
    }

    public static void main(String[] args) {
        SearchA2dMatrix_74 tc = new SearchA2dMatrix_74();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(tc.searchMatrix(matrix, 13));
    }
}
