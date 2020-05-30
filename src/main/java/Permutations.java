import java.util.HashSet;
import java.util.List;

import java.util.ArrayList;
import java.util.Set;

/**
 * Program: LeetCode
 * Description: Medium，排列题
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class Permutations {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

    }

    private void add(int[] nums, int i) {
        if (i==nums.length-1){
            return;
        }
        add(nums);;
    }

    private void add(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        result.add(list);
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }


    public static void main(String[] args) {
        Permutations tc = new Permutations();
        int[] nums = new int[]{
                1, 2, 3
        };
        System.out.println(tc.permute(nums));
    }
}
