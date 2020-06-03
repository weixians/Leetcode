/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int count = 0;
        boolean meetZero = false;
        boolean success = true;
        //逆序遍历数组
        for (int i = nums.length - 2; i >= 0; i--) {
            //当碰到0时，向前遍历寻找是否有可以跳过这个点的方法
            if (nums[i] == 0 && !meetZero) {
                meetZero = true;
                success = false;
            } else if (meetZero) {
                count++;
                if (nums[i] > count) {
                    meetZero = false;
                    success = true;
                    count = 0;
                }
            }
        }
        return success;
    }

    public static void main(String[] args) {
        JumpGame_55 tc = new JumpGame_55();
        int[] nums = {2, 0, 0};
        System.out.println(tc.canJump(nums));
    }
}
