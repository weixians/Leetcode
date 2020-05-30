/**
 * Program: LeetCode
 * Description: 未完成
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class SearchInRotatedSortedArray_33 {
    //TODO 未完成
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int middle = nums.length / 2;
        search(nums, 0, middle, target);
        search(nums, middle, nums.length, target);
        return index;
    }

    private int index = -1;

    private void search(int[] nums, int left, int right, int target) {
        int len = right - left;
        if (index != -1) {
            return;
        }
        if (len <= 2) {
            for (int i = 0; i < len; i++) {
                if (nums[left + i] == target) {
                    index = left + i;
                }
            }
            return;
        }
        int middle = (left + right) / 2;
        search(nums, left, middle, target);
        search(nums, middle, right, target);
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray_33 tc = new SearchInRotatedSortedArray_33();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(tc.search(nums, 0));
    }
}
