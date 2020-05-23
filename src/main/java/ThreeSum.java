import java.util.*;

/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class ThreeSum {

    /**
     * 参考自网上答案，19ms
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum < 0) {
                        left++;
                    } else if (sum > 0) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum tc = new ThreeSum();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        System.out.println(tc.threeSum(nums));
        nums = new int[]{0, 0, 0};
        System.out.println(tc.threeSum(nums));
//        nums = new int[]{1, 2, -2, -1};
//        System.out.println(tc.threeSum(nums));
//        nums = new int[]{-1, 0, 1};
//        System.out.println(tc.threeSum(nums));
//        nums = new int[]{0, 0, 0};
//        System.out.println(tc.threeSum(nums));
        nums = new int[]{3, 0, -2, -1, 1, 2};
        System.out.println(tc.threeSum(nums));
    }
}
