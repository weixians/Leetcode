/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        StringBuilder sb1 = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder(s);
        sb2.reverse();
        String res = null;
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i + 1; j--) {
                if (res != null && j - i < res.length()) {
                    break;
                }
                String s1 = sb1.substring(i, j);
                String s2 = sb2.substring(len - j, len - i);
                if (s1.equals(s2)) {
                    if (res == null) {
                        res = s1;
                    } else if (res.length() < s1.length()) {
                        res = s1;
                    }
                }
            }
        }
        if (res != null) {
            return res;
        } else if (s.length() >= 1) {
            return s.substring(0, 1);
        }
        return "";
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring_5 tc = new LongestPalindromicSubstring_5();
        String s = "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
        String res = tc.longestPalindrome(s);
        System.out.println(res);
    }
}
