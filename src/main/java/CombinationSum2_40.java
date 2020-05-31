import java.util.*;

/**
 * Program: LeetCode
 * Description: Medium
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class CombinationSum2_40 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        dfs(candidates, target, new Stack<>(), candidates.length - 1);
        return res;
    }

    private void dfs(int[] candidates, int target, Stack<Integer> buf, int index) {
        //使用HashSet去掉相同的子树
        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i >= 0; i--) {
            if (!set.add(candidates[i])) {
                continue;
            }
            if (candidates[i] == target) {
                buf.push(target);
                res.add(new ArrayList<>(buf));
                buf.pop();
            } else if (candidates[i] < target) {
                buf.push(candidates[i]);
                //index-1，在子树中跳过遍历当前元素
                dfs(candidates, target - candidates[i], buf, i - 1);
                buf.pop();
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum2_40 tc = new CombinationSum2_40();
        int[] candidates = new int[]{
                10, 1, 2, 7, 6, 1, 5
        };
        int target = 8;
        System.out.println(tc.combinationSum2(candidates, target));
    }
}
