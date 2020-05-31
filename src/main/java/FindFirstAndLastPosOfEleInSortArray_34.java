/**
 * Program: LeetCode
 * Description: Medium
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class FindFirstAndLastPosOfEleInSortArray_34 {
    int leftPos = -1;
    int rightPos = -1;

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{
                    leftPos, rightPos
            };
        }
        dfs(nums, 0, nums.length, target);
        return new int[]{leftPos, rightPos};
    }

    private void dfs(int[] nums, int left, int right, int target) {
        if (right - left <= 1) {
            if (nums[left] == target) {
                if (leftPos == -1 || leftPos > left) {
                    leftPos = left;
                }
                if (rightPos == -1 || rightPos < left) {
                    rightPos = left;
                }
            }
            return;
        }
        int middle = (left + right) / 2;
        //若中间点比target小并且最右边比target大，执行右边的搜索
        if (nums[middle] < target && nums[right - 1] >= target) {
            dfs(nums, middle, right, target);
        }
        //若中间点刚好等于target，则左右边都需要搜索才行
        if (nums[middle] == target) {
            dfs(nums, left, middle, target);
            dfs(nums, middle, right, target);
        }
        //若最左边比target小，且中间点比target大,执行左边的搜索
        if (nums[middle] > target && nums[left] <= target) {
            dfs(nums, left, middle, target);
        }
    }

    public static void main(String[] args) {
        FindFirstAndLastPosOfEleInSortArray_34 tc = new FindFirstAndLastPosOfEleInSortArray_34();
        int[] nums = {
                5, 7, 7, 8, 8, 10
        };
        int target = 8;
        tc.searchRange(nums, target);
        System.out.println(tc.leftPos + "," + tc.rightPos);
    }
}
