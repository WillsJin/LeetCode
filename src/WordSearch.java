import java.util.Arrays;

/**
 * Created by wills on 15/4/16.
 *
 * See https://leetcode.com/problems/word-search/
 *
 * Author https://github.com/WillsJin
 */
public class WordSearch
{

    char[][] board;
    boolean[][] used;
    int n, m;
    // → n, j
    // ↓ m, i

    public boolean exist(char[][] board, String word) {

        this.board = board;
        this.m = board.length;
        if (this.m < 0) {
            return false;
        }
        this.n = board[0].length;
        if (this.n < 0) {
            return  false;
        }
        this.used = new boolean[this.m][this.n];

        for (int i = 0; i < this.m; i++) {
            for (int j =0; j < this.n; j++) {
                this.used[i][j] = false;
            }
        }

        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {

                boolean result = search(i, j, word.toCharArray());
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(int i, int j, char[] chars) {

        if (chars.length <= 0) {
            return false;
        }
        if (board[i][j] == chars[0]) {

            this.used[i][j] = true;
            if (chars.length == 1) {

                return true;
            }

            // search 4 Direction\
            boolean result;
            char[] copy = Arrays.copyOfRange(chars, 1, chars.length);

//            for (int k = 0; k < 4; k++) {
//                switch (k) {
//                    case 0: break;
//                    case 1: break;
//                    case 2: break;
//                    case 3: break;
//                    default:
//
//                }
//            }

            // left
            if (j - 1 >= 0 && !this.used[i][j - 1]) {

                result = search(i, j - 1, copy);
                if (result) {
                    return true;
                }
            }

            // right
            if (j + 1 < n && !this.used[i][j + 1]) {

                result = search(i, j + 1, copy);
                if (result) {
                    return true;
                }
            }
            // top
            if (i - 1 >= 0 && !this.used[i - 1][j]) {

                result = search(i - 1, j, copy);
                if (result) {
                    return true;
                }
            }

            // bottom
            if (i + 1 < m && !this.used[i + 1][j]) {

                result = search(i + 1, j, copy);
                if (result) {
                    return true;
                }
            }

            this.used[i][j] = false;
        }
        return false;
    }

    public static void main(String[] args) {

        WordSearch solution = new WordSearch();

        char[][] board = new char[][]{"ABCE".toCharArray(), "SFCS".toCharArray(), "ADEE".toCharArray()};

        boolean result = solution.exist(board, "ABCB");
        System.out.println(result);
    }
}

