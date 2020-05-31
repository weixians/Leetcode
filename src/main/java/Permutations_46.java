import java.util.List;

import java.util.ArrayList;

/**
 * Program: LeetCode
 * Description: Medium，排列题。递归题优先考虑使用深度优先搜索
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class Permutations_46 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        dfs(numList, new ArrayList<>());
        return result;
    }

    /**
     * 深度优先搜索
     *
     * @param numList
     * @param buf
     */
    private void dfs(List<Integer> numList, List<Integer> buf) {
        //到叶子节点，将结果加入result中
        if (numList.size() <= 0) {
            result.add(buf);
            return;
        }
        for (int num : numList) {
            List<Integer> buf2 = new ArrayList<>(buf);
            buf2.add(num);
            List<Integer> numList2 = new ArrayList<>(numList);
            numList2.remove(Integer.valueOf(num));
            dfs(numList2, buf2);
        }
    }

    public static void main(String[] args) {
        Permutations_46 tc = new Permutations_46();
        int[] nums = new int[]{
                1, 2, 3
        };
        System.out.println(tc.permute(nums));
    }
}
