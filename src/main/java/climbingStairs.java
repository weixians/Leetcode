/**
 * Program: LeetCode
 * Description: Easy
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class climbingStairs {
    public int climbStairs(int n) {
        int prev1 = 0, prev2 = 1, result = 0;
        for (int i = 1; i <= n; i++) {
            result = prev1 + prev2;
            prev1 = prev2;
            prev2 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        climbingStairs tc = new climbingStairs();
        System.out.println(tc.climbStairs(2));
    }
}
