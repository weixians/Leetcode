import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Program: LeetCode
 * Description: Medium
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int left = j + 1, right = nums.length - 1;
                        while (left < right) {
                            int sum = nums[i] + nums[j] + nums[left] + nums[right];
                            if (sum < target) {
                                left++;
                            } else if (sum > target) {
                                right--;
                            } else {
                                result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
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
            }

        }
        return result;
    }

    public static void main(String[] args) {
        FourSum tc = new FourSum();
        int[] nums = new int[]{0, 0, 0, 0};
        System.out.println(tc.fourSum(nums, 0));
    }
}
