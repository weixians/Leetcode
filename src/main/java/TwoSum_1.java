import java.util.Map;

import java.util.HashMap;

public class TwoSum_1 {
    /**
     * 参考自LeetCode的讨论区
     * 思路：使用map记录所有的
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];
            if (map.containsKey(rest) && map.get(rest) != i) {
                return new int[]{i, map.get(rest)};
            }
        }
        return new int[]{0, 0};
    }

    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (n + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        TwoSum_1 ts = new TwoSum_1();
        int[] nums = new int[]{2, 7, 11, 15};
        int[] result = ts.twoSum(nums, 9);
        System.out.println(result[0] + "," + result[1]);
        nums = new int[]{3, 3};
        result = ts.twoSum(nums, 6);
        System.out.println(result[0] + "," + result[1]);
    }
}
