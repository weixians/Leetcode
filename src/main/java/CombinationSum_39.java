import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Program: LeetCode
 * Description: Medium. Time:9ms,有点慢
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class CombinationSum_39 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        //排序一下可以使得递归提前结束，减少运行时间
        Arrays.sort(candidates);
        List<Integer> candidateList = new ArrayList<>();
        for (int can : candidates) {
            candidateList.add(can);
        }
        dfs(candidateList, target, new ArrayList<>(), candidateList.size() - 1);
        return res;
    }

    private void dfs(List<Integer> candidateList, int target, List<Integer> buf, int index) {
        int sum = 0;
        for (Integer integer : buf) {
            sum += integer;
        }
        if (sum == target) {
            res.add(buf);
            return;
        } else if (sum > target) {
            return;
        }
        //我的方案的缺点在于每次都需要新建一个list
        List<Integer> temp = new ArrayList<>(candidateList);
        for (int i = index; i >= 0; i--) {
            int can = candidateList.get(i);
            //我的方案的缺点在于每次都需要新建一个list
            List<Integer> l = new ArrayList<>(buf);
            l.add(can);
            dfs(temp, target, l, i);
            //去掉这个数，使得相邻结点没有这个数的子树
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum_39 tc = new CombinationSum_39();
        int[] candidates = new int[]{
                10, 1, 2, 7, 6, 1, 5
        };
        int target = 8;
        System.out.println(tc.combinationSum(candidates, target));
    }
}
