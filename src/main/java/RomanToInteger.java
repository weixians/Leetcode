import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    /**
     * 自己实现，目前全网最快
     *
     * @param s
     * @return
     */
    public int romanToInt0(String s) {
        char I = 'I';
        char V = 'V';
        char X = 'X';
        char L = 'L';
        char C = 'C';
        char D = 'D';
        char M = 'M';
        char[] array = s.toCharArray();
        int sum = 0;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (array[i] == I) {
                if (i + 1 < length) {
                    if (array[i + 1] == V) {
                        sum += 4;
                        i++;
                    } else if (array[i + 1] == X) {
                        sum += 9;
                        i++;
                    } else {
                        sum += 1;
                    }
                } else {
                    sum += 1;
                }
            } else if (array[i] == X) {
                if (i + 1 < length) {
                    if (array[i + 1] == L) {
                        sum += 40;
                        i++;
                    } else if (array[i + 1] == C) {
                        sum += 90;
                        i++;
                    } else {
                        sum += 10;
                    }
                } else {
                    sum += 10;
                }
            } else if (array[i] == C) {
                if (i + 1 < length) {
                    if (array[i + 1] == D) {
                        sum += 400;
                        i++;
                    } else if (array[i + 1] == M) {
                        sum += 900;
                        i++;
                    } else {
                        sum += 100;
                    }
                } else {
                    sum += 100;
                }
            } else if (array[i] == V) {
                sum += 5;
            } else if (array[i] == L) {
                sum += 50;
            } else if (array[i] == D) {
                sum += 500;
            } else if (array[i] == M) {
                sum += 1000;
            }
        }
        return sum;
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        char pre = 'n';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sum += map.get(c);
            if (pre != 'n' && map.get(c) > map.get(pre)) {
                sum -= 2 * map.get(pre);
            }
            pre = c;
        }
        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger rim = new RomanToInteger();
        String[] testCases = {"IV", "IX", "LVIII", "MCMXCIV", "DCXXI"};
        for (int i = 0; i < testCases.length; i++) {
            int result = rim.romanToInt(testCases[i]);
            System.out.println(result);
        }
    }
}
