public class ImplementStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        char[] data = needle.toCharArray();
        int pos = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == data[0]) {
                int index = i + 1;
                boolean equal = true;
                for (int j = 1; j < data.length; j++) {
                    if (index >= haystack.length() || data[j] != haystack.charAt(index)) {
                        equal = false;
                        break;
                    }
                    index++;
                }
                if (equal) {
                    pos = i;
                    break;
                }
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        ImplementStr strStr = new ImplementStr();
        String haystack = "hello";
        String needle = "ll";
        int res = strStr.strStr(haystack, needle);
        System.out.println(res);

        haystack = "aaaaa";
        needle = "bba";
        res = strStr.strStr(haystack, needle);
        System.out.println(res);

        haystack = "mississippi";
        needle = "issip";
        res = strStr.strStr(haystack, needle);
        System.out.println(res);


    }
}
