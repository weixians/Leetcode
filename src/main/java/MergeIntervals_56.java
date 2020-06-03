import java.util.*;

/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int res = o1[0] - o2[0];
                if (res != 0) {
                    return res;
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] arr = stack.pop();
            int aRight = arr[1];
            int bLeft = intervals[i][0];
            int bRight = intervals[i][1];
            if (bLeft <= aRight) {
                if (bRight > aRight) {
                    arr[1] = bRight;
                }
                stack.push(arr);
            } else {
                stack.push(arr);
                stack.push(intervals[i]);
            }
        }
        int[][] res = new int[stack.size()][2];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        MergeIntervals_56 tc = new MergeIntervals_56();
        int[][] intervals = {{1, 4}, {0, 2}, {3, 5}};
        tc.merge(tc.merge(intervals));
    }
}
