import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Program: LeetCode
 * Description: Medium
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class GenerateParenthese {
    /**
     * 滚雪球模式
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        item.add(1);
        list.add(item);
        int len = n * 2;
        int[] nums = new int[]{1, -1};
        for (int i = 1; i < len; i++) {
            List<List<Integer>> newList = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                int sum = 0;
                int leftCount = 0;
                item = list.get(j);
                for (Integer integer : item) {
                    sum += integer;
                    if (integer == 1) {
                        leftCount++;
                    }
                }
                for (int num : nums) {
                    if (leftCount >= n && num == 1) {
                        continue;
                    }
                    if (sum + num >= 0) {
                        List<Integer> temp = new ArrayList<>(item);
                        temp.add(num);
                        newList.add(temp);
                    }
                }
            }
            if (!newList.isEmpty()) {
                list = newList;
            }
        }
        List<String> result = new ArrayList<>();
        for (List<Integer> integers : list) {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : integers) {
                if (integer == 1) {
                    sb.append("(");
                } else {
                    sb.append(")");
                }
            }
            result.add(sb.toString());
        }
        return result;
    }

    /**
     * 深度优先搜索模式
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesisByDfs(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs("", n, n, res);
        return res;
    }

    private void dfs(String currentStr, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(currentStr);
            return;
        }
        if (left > 0) {
            dfs(currentStr + "(", left - 1, right, res);
        }
        if (right > 0 && left < right) {
            dfs(currentStr + ")", left, right - 1, res);
        }
    }

    public static void main(String[] args) {
        GenerateParenthese tc = new GenerateParenthese();
        tc.generateParenthesis(3);
    }
}
