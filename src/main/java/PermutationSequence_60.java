import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class PermutationSequence_60 {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        int product = 1;
        for (int i = 2; i < n; i++) {
            product *= i;
        }
        int x = k / product;
        if (k % product == 0) {
            x--;
        }
        int rangeStart = product * x, rangeEnd = product * (x + 1);
        dfs(0, nums, rangeStart, rangeEnd);
        //排序
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for (int i = 0; i < o1.length; i++) {
                    if (o1[i] != o2[i]) {
                        return o1[i] - o2[i];
                    }
                }
                return 0;
            }
        });
        if (rangeStart == 0) {
            rangeStart = 1;
        }
        int pos = k - rangeStart;
        int[] res = list.get(pos);
        StringBuilder sb = new StringBuilder();
        for (int r : res) {
            sb.append(r);
        }
        return sb.toString();
    }

    private int count = 0;
    private List<int[]> list = new ArrayList<>();

    public void dfs(int index, int[] nums, int rangeStart, int rangeEnd) {
        if (index == nums.length - 1) {
            count++;
            if (count >= rangeStart && count <= rangeEnd) {
                int[] buf = new int[nums.length];
                System.arraycopy(nums, 0, buf, 0, nums.length);
                list.add(buf);
            }
            return;
        }
        if (count > rangeEnd) {
            return;
        }
        for (int j = index; j < nums.length; j++) {
            swap(nums, index, j);
            dfs(index + 1, nums, rangeStart, rangeEnd);
            swap(nums, index, j);
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
        PermutationSequence_60 tc = new PermutationSequence_60();
        int n = 4, k = 6;
        System.out.println(tc.getPermutation(n, k));
    }
}
