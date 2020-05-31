import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Program: LeetCode
 * Description: Medium，排列题。递归题优先考虑使用深度优先搜索
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class Permutations_47 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {             // For corner case
            res.add(new ArrayList<>());
            return res;
        }
        dfs(0, nums);
        return res;
    }

    public void dfs(int i, int[] nums) {
        if (i == nums.length - 1) {
            List<Integer> l = new ArrayList<>();
            for (int j : nums)
                l.add(j);
            res.add(l);
            return;
        }
        //用hashset可以防止和同一种元素重复交换，好方法！
        HashSet<Integer> set = new HashSet<>();
        for (int j = i; j < nums.length; j++) {
            if (set.add(nums[j])) {
                swap(nums, i, j);
                dfs(i + 1, nums);
                swap(nums, i, j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        Permutations_47 tc = new Permutations_47();
        int[] nums = new int[]{
                2, 2, 1, 1,
        };
        System.out.println(tc.permuteUnique(nums));
    }
}
