import java.util.List;

import java.util.ArrayList;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean running = true;
        int index = 0;
        while (running) {
            if (index >= strs[0].length()) {
                break;
            }
            char c = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || c != strs[i].charAt(index)) {
                    running = false;
                    break;
                }
            }
            if (running) {
                sb.append(c);
            }
            index++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {
                "flower", "flow", "flight"
        };
        String result = lcp.longestCommonPrefix(strs);
        System.out.println(result);
    }
}
