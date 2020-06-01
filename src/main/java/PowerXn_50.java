/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class PowerXn_50 {
    public double myPow(double x, int n) {
        double res = 1;
        for (int i = 0; i < n; i++) {
            res *= x;
            if (res >= Double.POSITIVE_INFINITY) {
                res = 1.0 / 0;
                break;
            } else if (res <= Double.NEGATIVE_INFINITY) {
                res = -1.0 / 0;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PowerXn_50 tc = new PowerXn_50();

    }
}
