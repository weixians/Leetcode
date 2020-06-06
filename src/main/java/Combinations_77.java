import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Program: LeetCode
 * Description: Medium
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class Combinations_77 {
    /**
     * 递归解法，深度优先搜索
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(1, n, k, new Stack<>(), res);
        return res;
    }

    private void dfs(int start, int n, int k, Stack<Integer> stack, List<List<Integer>> res) {
        //用减法的方式
        if (k == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        //进入1或者某个数的子树时，end最终会变成n
        for (int i = start; i <= n - k + 1; i++) {
            stack.push(i);
            dfs(i + 1, n, k - 1, stack, res);
            stack.pop();
        }
    }

    /**
     * 动态规划解法
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();


        return res;
    }

    public static void main(String[] args) {
        Combinations_77 tc = new Combinations_77();
        System.out.println(tc.combine(4, 2));
    }
}
