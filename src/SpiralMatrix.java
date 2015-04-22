import java.util.ArrayList;
import java.util.List;

/**
 * Created by wills on 15/4/21.
 *
 * See https://leetcode.com/problems/spiral-matrix/
 *
 * Author https://github.com/WillsJin
 */
public class SpiralMatrix
{
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<Integer>();

        int m = matrix.length;
        if (m <= 0) {
            return result;
        }
        int n = matrix[0].length;
        boolean[][] flag = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                flag[i][j] = false;
            }
        }
        int turn = 0;
        int i = 0, j = 0;

        result.add(matrix[0][0]);
        flag[0][0] = true;

        while (result.size() < m * n) {
            int _i = 0, _j = 0;
            switch (turn % 4) {
                case 0 : _i = i; _j = j + 1; break;
                case 1 : _i = i + 1; _j = j; break;
                case 2 : _i = i; _j = j - 1; break;
                case 3 : _i = i - 1; _j = j; break;
            }

            if (0 <= _i && _i < m && 0 <= _j && _j < n && !flag[_i][_j]) {
                i = _i;
                j = _j;
                result.add(matrix[i][j]);
                flag[i][j] = true;
            } else {
                turn++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        SpiralMatrix solution = new SpiralMatrix();
        int[][] matrix = new int[][]{{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }};
        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println(result);
    }
}
