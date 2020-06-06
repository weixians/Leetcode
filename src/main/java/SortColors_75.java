/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class SortColors_75 {
    /**
     * 不处理1，将0移到左边，将2移到右边
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int posOne = -1;
        while (left <= right) {
            //过滤掉尾部为2的，无需遍历
            while (left < right && nums[right] == 2) {
                right--;
            }
            if (nums[left] == 0) {
                //判断这个0的前面是否有1
                if (posOne != -1) {
                    swap(nums, left, posOne);
                    //更新第一个1出现的位置
                    posOne = Math.min(left, posOne + 1);
                } else {
                    left++;
                }
            } else if (nums[left] == 1) {
                //记录第一个1出现的位置
                if (posOne == -1)
                    posOne = left;
                left++;
            } else if (nums[left] == 2) {
                swap(nums, left, right);
                right--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors_75 tc = new SortColors_75();
        int[] nums = {2, 0, 2, 1, 1, 0};
        nums = new int[]{1, 1, 0};
        nums = new int[]{1, 1, 0, 0, 1, 1};
        tc.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}
