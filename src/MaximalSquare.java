/**
 * Created by wills on 15/6/3.
 *
 * See https://leetcode.com/problems/maximal-square/
 *
 * Author https://github.com/WillsJin
 */
public class MaximalSquare
{
    public int maximalSquare(char[][] matrix) {

        if (matrix.length <= 0) {
            return 0;
        }
        int m = matrix[0].length, n = matrix.length;
        int[][] status = new int[n][m];
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                status[i][j] = matrix[i][j] - '0';
            }
        }
        for (int k = 1; k < (n > m ? n : m); k++)
        {
            for (int i = 0; i < matrix.length - 1; i++)
            {
                for (int j = 0; j < matrix[i].length - 1; j++)
                {
                    if (status[i][j] == k && status[i][j + 1] == k
                            && status[i + 1][j] == k && status[i + 1][j + 1] == k) {

                        status[i][j] = k + 1;
                    }
                }
            }

        }

        int max = 0;
        for (int[] row : status)
        {
            for (int item : row)
            {
                if (max < item)
                {
                    max = item;
                }
            }
        }

        return max * max;
    }

    public static void main(String[] args)
    {
        MaximalSquare solution = new MaximalSquare();
//        char[][] matrix = new char[][]{
//                {'1', '0', '1', '0', '0'},
//                {'1', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'}
//        };
        char[][] matrix = new char[][]{
                {'1', '1'},
                {'1', '1'}
        };
        int result = solution.maximalSquare(matrix);
        System.out.println(result);
    }
}
