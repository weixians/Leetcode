import java.util.HashMap;
import java.util.Map;

/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] sizes = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        for (Integer size : sizes) {
            num = append(map, sb, num, size);
        }
        return sb.toString();
    }

    private int append(Map<Integer, String> map, StringBuilder sb, int num, int size) {
        int count = num / size;
        for (int i = 0; i < count; i++) {
            sb.append(map.get(size));
        }
        return num - count * size;
    }

    public static void main(String[] args) {
        IntegerToRoman tc = new IntegerToRoman();
        System.out.println(tc.intToRoman(1994));
    }
}
