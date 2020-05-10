import org.junit.Assert;

/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class ZigzagConversion {

    public String convert(String s, int numRows) {
        //确定列数
        int numCols = 0;
        int len = s.length();
        int colIndex = 0;
        if (numRows == 1) {
            numCols = s.length();
        } else {
            while (len > 0) {
                if (colIndex % (numRows - 1) == 0) {
                    len -= numRows;
                } else {
                    len -= 1;
                }
                numCols++;
                colIndex++;
            }
        }
        char[][] array = new char[numRows][numCols];
        //初始化数组
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                array[i][j] = '#';
            }
        }
        colIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (numRows == 1) {
                array[0][colIndex] = s.charAt(i);
            } else {
                if (colIndex % (numRows - 1) == 0) {
                    for (int j = 0; j < numRows && i < s.length(); j++) {
                        char c = s.charAt(i);
                        array[j][colIndex] = c;
                        i++;
                    }
                    i--;
                } else {
                    array[numRows - 1 - (i % (numRows - 1))][colIndex] = s.charAt(i);
                }
            }

            colIndex++;
        }
//        for (int i = 0; i < numRows; i++) {
//            for (int j = 0; j < numCols; j++) {
//                System.out.print(array[i][j] + " ");
//            }
//            System.out.println();
//        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (array[i][j] != '#') {
                    sb.append(array[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion tc = new ZigzagConversion();
        String s = "A";
        System.out.println(tc.convert(s, 1));
    }
}
