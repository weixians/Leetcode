import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class PlusOne {
    /**
     * 自己实现，1ms
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;
        List<Integer> list = new ArrayList<>();
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] > 9) {
                if (i - 1 >= 0) {
                    digits[i - 1] += 1;
                } else {
                    list.add(0);
                    list.add(1);
                    break;
                }
                list.add(0);
            } else {
                list.add(digits[i]);
            }
        }
        Collections.reverse(list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 自己实现，最快。0ms
     *
     * @param digits
     * @return
     */
    public int[] plusOne1(int[] digits) {
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] > 9) {
                if (i - 1 >= 0) {
                    digits[i - 1] += 1;
                    digits[i] = 0;
                } else {
                    digits[i] = 10;
                }
            }
        }
        if (digits[0] > 9) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] digits = new int[]{1, 2, 3};
        int[] res = plusOne.plusOne(digits);
    }
}
