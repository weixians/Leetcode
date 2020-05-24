import java.util.ArrayList;
import java.util.List;

/**
 * Program: LeetCode
 * Description:LetterCombinationsOfAPhoneNumber网上版本
 * Author: Weixian Shi
 * Create Time: 2020-05-24 16:51
 **/
public class LetterCombinationsOfAPhoneNumberOnline {
    private static String[] map = {
            "",
            "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return res;
        char[] buffer = new char[digits.length()];
        buildExp(0, buffer, digits, res);
        return res;
    }

    private void buildExp(int curIndex, char[] buf, String src, List<String> res) {
        if (curIndex >= src.length()) {
            res.add(String.valueOf(buf, 0, buf.length));
        } else {
            int curNum = src.charAt(curIndex) - '0';
            String val = map[curNum];
            for (char c : val.toCharArray()) {
                buf[curIndex] = c;
                buildExp(curIndex + 1, buf, src, res);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumberOnline t = new LetterCombinationsOfAPhoneNumberOnline();
        System.out.println(t.letterCombinations("23"));
    }
}
