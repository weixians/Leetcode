/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int index = -1;
        //找到最后一个前面小于后面的数
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                index = i;
            }
        }
        if (index == -1) {
            reverse(nums);
        } else {
            int biggerIndex = -1;
            int currentBig = Integer.MAX_VALUE;
            //找到比当前数大的最小数
            for (int i = index + 1; i < nums.length; i++) {
                if (nums[index] < nums[i] && currentBig > nums[i]) {
                    currentBig = nums[i];
                    biggerIndex = i;
                }
            }
            if (biggerIndex != -1) {
                swap(nums, index, biggerIndex);
            } else {
                swap(nums, index, index + 1);
            }
            for (int i = index + 1; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] > nums[j]) {
                        swap(nums, i, j);
                    }
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length / 2; i++) {
            temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {
        NextPermutation_31 tc = new NextPermutation_31();
        int[] nums = new int[]{1, 3, 2, 0};
        tc.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
