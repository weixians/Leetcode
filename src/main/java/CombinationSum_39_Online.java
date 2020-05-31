import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Program: LeetCode
 * Description: Medium。网上答案，1ms
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class CombinationSum_39_Online {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> comb = new Stack<>();
        find(candidates, target, comb, 0, result);
        return result;
    }

    /**
     * 采用target逐步减小的方法
     *
     * @param candidates
     * @param target
     * @param comb
     * @param k
     * @param result
     */
    private void find(int[] candidates, int target, Stack<Integer> comb, int k, List<List<Integer>> result) {
        for (int i = k; i < candidates.length; i++) {
            if (candidates[i] == target) {
                comb.push(candidates[i]);
                result.add(new ArrayList<>(comb));
                comb.pop();
            } else if (candidates[i] < target) {
                comb.push(candidates[i]);
                find(candidates, target - candidates[i], comb, i, result);
                comb.pop();
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum_39_Online tc = new CombinationSum_39_Online();
        int[] candidates = new int[]{
                2, 3, 5
        };
        int target = 8;
        System.out.println(tc.combinationSum(candidates, target));
    }
}
