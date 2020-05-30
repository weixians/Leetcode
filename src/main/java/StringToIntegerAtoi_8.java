/**
 * Program: LeetCode
 * Description: String字符串转为Int
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class StringToIntegerAtoi_8 {
    public int myAtoi(String str) {
        str = str.trim();
        long result = 0;
        boolean negative = false;
        StringBuilder sb = new StringBuilder();
        if (str.length() > 0 && str.charAt(0) == '-') {
            negative = true;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '-' || c == '+')) {
                continue;
            }
            if (c >= '0' && c <= '9') {
                sb.append(c);
            } else {
                break;
            }
        }
        int count = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            result += (sb.charAt(i) - 48) * Math.pow(10, count);
            count++;
            if (result > Integer.MAX_VALUE) {
                if (negative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
        if (negative) {
            result = -result;
        }
        if (result < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        } else if (result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        }
        return (int) result;
    }


    public static void main(String[] args) {
        StringToIntegerAtoi_8 tc = new StringToIntegerAtoi_8();
        String s = "-42";
        System.out.println(tc.myAtoi(s));

    }
}
