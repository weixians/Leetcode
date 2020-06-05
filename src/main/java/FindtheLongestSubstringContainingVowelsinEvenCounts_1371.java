import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ArrayList;

/**
 * Program: LeetCode
 * Description: Medium, 寻找包含偶数个元音字母的最长子字符串
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class FindtheLongestSubstringContainingVowelsinEvenCounts_1371 {
    public int findTheLongestSubstring(String s) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //数组下标为0，因此第0个非元音字母的情况，长度应该为1.因此这里的map中0要为-1
        map.put(0, -1);
        int state = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //这里要采用n次方才行，才能够达到下次遇到同一个数时从state中减掉该数
            switch (ch) {
                case 'a':
                    state ^= 1 << 0;
                    break;
                case 'e':
                    state ^= 1 << 1;
                    break;
                case 'i':
                    state ^= 1 << 2;
                    break;
                case 'o':
                    state ^= 1 << 3;
                    break;
                case 'u':
                    state ^= 1 << 4;
                    break;
                default:
                    break;
            }
            if (map.containsKey(state)) {
                res = Math.max(res, i - map.get(state));
            } else {
                map.put(state, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindtheLongestSubstringContainingVowelsinEvenCounts_1371 tc = new FindtheLongestSubstringContainingVowelsinEvenCounts_1371();
        String s = "eleetminicoworoep";
        System.out.println(tc.findTheLongestSubstring(s));
        System.out.println(2^4^8);
    }
}
