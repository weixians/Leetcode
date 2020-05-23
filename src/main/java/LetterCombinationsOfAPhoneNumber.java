import java.util.*;

/**
 * Program: LeetCode
 * Description: 自己解法，8ms
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class LetterCombinationsOfAPhoneNumber {
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        StringBuilder sb = new StringBuilder();
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        List<Character> digitList = new ArrayList<>();
        for (int i = digits.length() - 1; i >= 0; i--) {
            digitList.add(digits.charAt(i));
        }
        result.add("");
        form(digitList, map);
        result.remove("");
        return result;
    }

    private void form(List<Character> digitList, Map<Character, char[]> map) {
        if (digitList.size() <= 0) {
            return;
        }
        char c = digitList.remove(digitList.size() - 1);
        char[] chars = map.get(c);
        List<String> newResult = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < chars.length; j++) {
                newResult.add(result.get(i) + chars[j]);
            }
        }
        result = newResult;
        form(digitList, map);
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber tc = new LetterCombinationsOfAPhoneNumber();
        System.out.println(tc.letterCombinations("23"));
    }
}
