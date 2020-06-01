import java.util.*;

/**
 * Program: LeetCode
 * Description: Medium
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) {
            return res;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String s = String.valueOf(c);
            if (!map.containsKey(s)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            } else {
                map.get(s).add(str);
            }
        }
        res.addAll(map.values());
        return res;
    }

    public static void main(String[] args) {
        GroupAnagrams_49 tc = new GroupAnagrams_49();
        String[] strs = new String[]{
                "eat", "tea", "tan", "ate", "nat", "bat"
        };
        System.out.println(tc.groupAnagrams(strs));
    }
}
