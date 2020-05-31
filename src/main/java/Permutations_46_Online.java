import java.util.ArrayList;
import java.util.List;

/**
 * Program: LeetCode
 * Description: Medium，排列题。递归题优先考虑使用深度优先搜索
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class Permutations_46_Online {
    /**
     * 网上找的最快方法，比自己的少用一个list
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) {             // For corner case
            list.add(new ArrayList<>());
            return list;
        }
        dfs(0, nums, list);
        return list;
    }

    public void dfs(int i, int[] nums, List<List<Integer>> list) {
        if (i == nums.length - 1) {
            List<Integer> l = new ArrayList<>();
            for (int j : nums)
                l.add(j);
            list.add(l);
            return;
        }
        int t;
        for (int j = i; j < nums.length; j++) {
            //swapping b/w nums[i] and nums[j]
            t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;

            dfs(i + 1, nums, list);

            // again swapping b/w nums[i] and nums[j] so that overall swapping has no effect on nums[] arrray
            t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    public static void main(String[] args) {
        Permutations_46_Online tc = new Permutations_46_Online();
        int[] nums = new int[]{
                1, 2, 3
        };
        System.out.println(tc.permute(nums));
    }
}
