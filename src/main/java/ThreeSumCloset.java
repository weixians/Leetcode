import java.util.Arrays;

/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int minDistance = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    int distance = Math.abs(target - sum);
                    if (distance < minDistance) {
                        minDistance = distance;
                        result = sum;
                    } else if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        return sum;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSumCloset tc = new ThreeSumCloset();
        int[] nums = new int[]{1, 1, 1, 0};
        int target = 100;
        System.out.println(tc.threeSumClosest(nums, target));
        nums = new int[]{-1, 0, 1, 1, 55};
        target = 3;
        System.out.println(tc.threeSumClosest(nums, target));
        nums = new int[]{13, 2, 0, -14, -20, 19, 8, -5, -13, -3, 20, 15, 20, 5, 13, 14, -17, -7, 12, -6, 0, 20, -19, -1, -15, -2, 8, -2, -9, 13, 0, -3, -18, -9, -9, -19, 17, -14, -19, -4, -16, 2, 0, 9, 5, -7, -4, 20, 18, 9, 0, 12, -1, 10, -17, -11, 16, -13, -14, -3, 0, 2, -18, 2, 8, 20, -15, 3, -13, -12, -2, -19, 11, 11, -10, 1, 1, -10, -2, 12, 0, 17, -19, -7, 8, -19, -17, 5, -5, -10, 8, 0, -12, 4, 19, 2, 0, 12, 14, -9, 15, 7, 0, -16, -5, 16, -12, 0, 2, -16, 14, 18, 12, 13, 5, 0, 5, 6};
        target = -59;
        System.out.println(tc.threeSumClosest(nums, target));
    }
}
