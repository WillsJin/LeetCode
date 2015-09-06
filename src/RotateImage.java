/**
 * Created by wills on 15/9/2.
 * <p/>
 * See https://leetcode.com/problems/rotate-image/
 * <p/>
 * Author https://github.com/WillsJin
 */
public class RotateImage {

    public void rotate(int[][] matrix) {

        int n = matrix.length;
        if (n <= 0) {
            return;
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;

            }
        }
    }

    public static void main(String[] args) {

        RotateImage solution = new RotateImage();

        int[][] matrix = new int[][]{
                {0, 1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12, 13},
                {14, 15, 16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25, 26, 27},
                {28, 29, 30, 31, 32, 33, 34},
                {35, 36, 37, 38, 39, 40, 41},
                {42, 43, 44, 45, 46, 47, 48}};

        solution.rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }

    }
}
