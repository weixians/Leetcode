/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class MaximumSubarray {
    /**
     * 自己的方案
     *
     * @param nums
     * @return
     */
    public int maxSubArray0(int[] nums) {
        int tempMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (temp > tempMax) {
                    tempMax = temp;
                }
            }
        }
        return tempMax;
    }

    public int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int overallMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (currentMax < 0) {
                currentMax = nums[i];
            } else {
                currentMax += nums[i];
            }
            if (currentMax > overallMax) {
                overallMax = currentMax;
            }
        }
        return overallMax;
    }


    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = ms.maxSubArray(nums);
        System.out.println(result);

        nums = new int[]{-1};
        result = ms.maxSubArray(nums);
        System.out.println(result);
    }
}
