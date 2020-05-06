import java.util.ArrayList;
import java.util.List;

/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class AddBinary {
    /**
     * 网上最快方案
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i) - '0';
            if (j >= 0) sum += b.charAt(j) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public String addBinary1(String a, String b) {
        int maxLen = 0;
        if (a.length() > b.length()) {
            maxLen = a.length();
        } else {
            maxLen = b.length();
        }
        int[] arrayIntA = new int[a.length()];
        int[] arrayIntB = new int[b.length()];
        int[] res = new int[maxLen];
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '1') {
                arrayIntA[i] = 1;
            } else {
                arrayIntA[i] = 0;
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '1') {
                arrayIntB[i] = 1;
            } else {
                arrayIntB[i] = 0;
            }
        }
        for (int i = 0; i < maxLen; i++) {
            int indexa = a.length() - 1 - i;
            int indexb = b.length() - 1 - i;
            int temp;
            if (indexa < 0) {
                temp = arrayIntB[indexb];
            } else if (indexb < 0) {
                temp = arrayIntA[indexa];
            } else {
                temp = arrayIntA[indexa] + arrayIntB[indexb];
            }
            int resIndex = maxLen - 1 - i;
            if (temp >= 2) {
                if (resIndex - 1 >= 0) {
                    temp -= 2;
                    res[resIndex] += temp;
                    res[resIndex - 1] += 1;
                } else {
                    res[resIndex] += temp;
                }
            } else {
                res[resIndex] += temp;
            }
        }

        for (int i = res.length - 1; i >= 0; i--) {
            if (res[i] >= 2) {
                if (i - 1 >= 0) {
                    res[i] -= 2;
                    res[i - 1] += 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (res[0] >= 2) {
            sb.append("1");
            sb.append((res[0] - 2));
        } else {
            sb.append(res[0]);
        }
        for (int i = 1; i < maxLen; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AddBinary ab = new AddBinary();
        String a = "1";
        String b = "111";
        System.out.println(ab.addBinary1(a, b));
    }
}
