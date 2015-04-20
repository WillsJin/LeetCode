/**
 * Created by wills on 15/4/20.
 *
 * See https://leetcode.com/problems/minimum-path-sum/
 *
 * Author https://github.com/WillsJin
 */
public class MinimumPathSum
{

    public int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int[][] record = new int[n][m];

        record[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            record[i][0] = record[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < m; j++) {
            record[0][j] = record[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

                int min = record[i - 1][j];
                if (min > record[i][j - 1]) {
                    min = record[i][j - 1];
                }
                record[i][j] = min + grid[i][j];
            }
        }

        return record[n - 1][m - 1];
    }

    public static void main(String[] args) {

        int[][] grid = new int[][]{{1, 2, 3},{4, 5, 6}};

        MinimumPathSum solution = new MinimumPathSum();
        int result = solution.minPathSum(grid);
        System.out.println(result);

    }
}
