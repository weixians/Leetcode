/**
 * Program: LeetCode
 * Description: 模板�?
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] arr = s.split(" ");
        if (arr.length <= 1) {
            return s.trim().length();
        }
        return arr[arr.length - 1].length();
    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        String s = " ";
        int res = lengthOfLastWord.lengthOfLastWord(s);
        System.out.println(res);
    }
}
