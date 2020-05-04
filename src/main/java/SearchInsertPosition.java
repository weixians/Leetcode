/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class SearchInsertPosition {


    /**
     * 最好的办法
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        SearchInsertPosition s = new SearchInsertPosition();
        int pos = s.searchInsert(new int[]{1, 3, 5, 6}, 7);
        System.out.println(pos);
    }
}
