/**
 * 回文数字
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        int length = arr.length;
        for (int i = 0; i < length / 2; i++) {
            if (arr[i] != arr[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 网上速度最快的方案
     *
     * @param num
     * @return
     */
    public boolean isPalindrome1(int num) {
        int res = 0;
        int num1 = num;
        while (num > 0) {
            res = res * 10 + (num % 10);
            num = num / 10;
        }
        return num1 == res;
    }

    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        boolean result = pn.isPalindrome(121);
        System.out.println(result);
        result = pn.isPalindrome(-121);
        System.out.println(result);
        result = pn.isPalindrome(10);
        System.out.println(result);
        result = pn.isPalindrome(-10);
        System.out.println(result);
    }
}
