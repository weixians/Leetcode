/**
 * Program: LeetCode
 * Description: Medium
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class MultiplyStrings_43 {
    /**
     * 21ms
     * 关于相加，应该把每一组的结果作为string保存到list，最后再相加，会更快一些
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 <= 0) {
            return num2;
        } else if (len2 <= 0) {
            return num1;
        }
        StringBuilder res = new StringBuilder();
        StringBuilder sb;
        for (int i = len1 - 1; i >= 0; i--) {
            sb = new StringBuilder();
            int carry = 0;
            for (int j = len2 - 1; j >= 0; j--) {
                int p = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry;
                if (j != 0) {
                    carry = p / 10;
                    sb.append(p % 10);
                } else {
                    sb.reverse();
                    sb.insert(0, p);
                }
            }
            for (int k = 0; k < len1 - 1 - i; k++) {
                sb.append("0");
            }
            if (i == len1 - 1) {
                res = new StringBuilder(sb);
            } else {
                res = sum(res, sb);
            }
        }
        return res.toString();
    }

    private StringBuilder sum(StringBuilder sb1, StringBuilder sb2) {
        StringBuilder res = new StringBuilder();
        int maxLen = sb1.length();
        if (sb2.length() > maxLen) {
            maxLen = sb2.length();
        }
        int index1 = sb1.length() - 1;
        int index2 = sb2.length() - 1;
        int carry = 0;
        while (maxLen > 0) {
            int s;
            if (index1 >= 0 && index2 >= 0) {
                s = carry + sb1.charAt(index1) - '0' + sb2.charAt(index2) - '0';
            } else if (index1 >= 0) {
                s = carry + sb1.charAt(index1) - '0';
            } else {
                s = carry + sb2.charAt(index2) - '0';
            }
            if (maxLen > 1) {
                carry = s / 10;
                res.append(s % 10);
            } else {
                res.reverse();
                res.insert(0, s);
            }
            maxLen--;
            index1--;
            index2--;
        }
        return res;
    }

    public static void main(String[] args) {
        MultiplyStrings_43 tc = new MultiplyStrings_43();
//        String num1 = "23", num2 = "45";
//        System.out.println(tc.multiply(num1, num2));
        String num1 = "9113", num2 = "0";
        System.out.println(tc.multiply(num1, num2));
    }
}
