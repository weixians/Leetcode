import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Program: LeetCode
 * Description: Medium,检查数独是否符合规范. Time:2ms, 82.7%; memory:39.2M, 100%
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class ValidSudoku_36 {

    /**
     * 以每个box为单位进行遍历
     * 一次性检查所有条件
     * 另一种思路：先单独检查行和列，然后检查box
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Character>> rowList = new ArrayList<>();
        List<HashSet<Character>> colList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            rowList.add(new HashSet<>());
            colList.add(new HashSet<>());
        }
        HashSet<Character> boxSet = new HashSet<>();

        //看起来是四层循环，其实每个元素只遍历了一遍
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                //遍历一个box
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (board[k][l] == '.') {
                            continue;
                        }
                        if (!rowList.get(k).add(board[k][l])) {
                            return false;
                        }
                        if (!colList.get(l).add(board[k][l])) {
                            return false;
                        }
                        if (!boxSet.add(board[k][l])) {
                            return false;
                        }
                    }
                }
                boxSet.clear();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku_36 tc = new ValidSudoku_36();
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        board = new char[][]{{'.', '.', '4', '.', '.', '.', '6', '3', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, {'5', '.', '.', '.', '.', '.', '.', '9', '.'}, {'.', '.', '.', '5', '6', '.', '.', '.', '.'}, {'4', '.', '3', '.', '.', '.', '.', '.', '1'}, {'.', '.', '.', '7', '.', '.', '.', '.', '.'}, {'.', '.', '.', '5', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};

        System.out.println(tc.isValidSudoku(board));
    }
}
