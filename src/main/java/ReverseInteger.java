import java.util.ArrayList;
import java.util.List;

public class ReverseInteger {
    /**
     * 网上速度最快
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        boolean negative = x < 0;
        x = Math.abs(x);
        long result = 0;
        while (x > 0) {
            result = (result * 10) + (x % 10);
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return negative ? -(int) result : (int) result;
    }

    /**
     * 自己最快
     *
     * @param x
     * @return
     */
    public int reverse1(int x) {
        try {
            char[] sArr = String.valueOf(x).toCharArray();
            int start = 0;
            if (sArr[0] == '-') {
                start = 1;
            }
            int end = start + sArr.length - 1;
            for (int i = start; i < start + sArr.length / 2; i++) {
                char temp = sArr[i];
                sArr[i] = sArr[end - i];
                sArr[end - i] = temp;
            }
            return Integer.parseInt(String.valueOf(sArr));
        } catch (Exception e) {
            return 0;
        }
    }

    public int reverse2(int x) {
        try {
            List<Character> list = new ArrayList<>();
            String str = String.valueOf(x);
            int length = str.length();
            for (int i = length - 1; i >= 0; i--) {
                list.add(str.charAt(i));
            }
            if (list.get(length - 1) == '-') {
                list.remove(length - 1);
                list.add(0, '-');
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append(list.get(i));
            }
            return Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public int reverse3(int x) {
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(x));
            sb.reverse();
            int len = sb.length() - 1;
            if (sb.charAt(len) == '-') {
                sb.deleteCharAt(len);
                sb.insert(0, '-');
            }
            return Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        ReverseInteger r = new ReverseInteger();
        int result = r.reverse(123);
        System.out.println(result);
        result = r.reverse(-123);
        System.out.println(result);
        result = r.reverse(-10);
        System.out.println(result);
        result = r.reverse(10);
        System.out.println(result);
//        result = r.reverse(9646324351);
//        System.out.println(result);
    }
}
