import java.util.ArrayList;
import java.util.List;

/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class LongestSubstringWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();
        int len = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!list.contains(c)) {
                list.add(c);
                len++;
            } else {
                if (len > maxLen) {
                    maxLen = len;
                }
                int size = list.indexOf(c);
                for (int j = 0; j <= size; j++) {
                    list.remove(0);
                    len--;
                }
                len++;
                list.add(c);
            }
        }
        if (len > maxLen) {
            maxLen = len;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters_3 tc = new LongestSubstringWithoutRepeatingCharacters_3();
        System.out.println(tc.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(tc.lengthOfLongestSubstring("bbbbb"));
        System.out.println(tc.lengthOfLongestSubstring("pwwkew"));
        System.out.println(tc.lengthOfLongestSubstring(" "));
        System.out.println(tc.lengthOfLongestSubstring("dvdf"));
        System.out.println(tc.lengthOfLongestSubstring("ohomm"));
    }
}
