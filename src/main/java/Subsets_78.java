import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Program: LeetCode
 * Description: Medium
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new Stack<>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, Stack<Integer> stack, int start) {
        res.add(new ArrayList<>(stack));
        if (stack.size() == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            stack.push(nums[i]);
            dfs(nums, res, stack, i + 1);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Subsets_78 tc = new Subsets_78();

    }
}
