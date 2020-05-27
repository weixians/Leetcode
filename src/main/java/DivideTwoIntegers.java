import java.util.ArrayList;
import java.util.List;

/**
 * Program: LeetCode
 * Description: Medium
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        List<Integer> sumList = new ArrayList<>();
        List<Integer> nList = new ArrayList<>();

        boolean negative = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            negative = true;
        }
        //let dividend and divisor be negative
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        if (dividend > divisor) {
            return 0;
        }

        //let dividend be negative
        divisor = -divisor;

        int sum = -divisor;
        int n = 1;
        sumList.add(sum);
        nList.add(n);
        while (true) {
            if (sum > dividend && dividend - sum <= sum) {
                sum += sum;
                n += n;
                sumList.add(sum);
                nList.add(n);
                if (n < 0) {
                    if (!negative) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
            } else {
                for (int i = sumList.size() - 1; i >= 0; i--) {
                    if (sum > dividend && dividend - sum <= sumList.get(i)) {
                        sum += sumList.get(i);
                        n += nList.get(i);
                    }
                }
                break;
            }
        }
        if (negative) {
            return -n;
        } else {
            return n;
        }
    }

    public static void main(String[] args) {
        DivideTwoIntegers tc = new DivideTwoIntegers();
        int dividend = 7;
        int divisor = -3;
        System.out.println(tc.divide(dividend, divisor));
        dividend = 2147483647;
        divisor = 3;
        System.out.println(tc.divide(dividend, divisor));
    }
}
