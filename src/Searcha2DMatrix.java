/**
 * Created by wills on 16/4/11.
 */
public class Searcha2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length > 0 && matrix[0].length > 0) {
            if (matrix[0][0] <= target && target <= matrix[matrix.length - 1][matrix[matrix.length - 1].length - 1]) {

                int row = searchRow(matrix, target, 0, matrix.length);

                return searchLine(matrix[row], target, 0, matrix[row].length);
            }
        }
        return false;
    }

    private int searchRow(int[][] matrix, int target, int l, int r) {

        int i = (l + r) / 2;

        if (target < matrix[i][0]) {
            return searchRow(matrix, target, l, i);
        }

        if (i + 1 < matrix.length) {

            if (matrix[i][0] <= target && target < matrix[i + 1][0]) {
                return i;
            } else {
                return searchRow(matrix, target, i, r);
            }
        } else {
            return i;
        }
    }

    private boolean searchLine(int[] row, int target, int l, int r) {

        if (l > r || l >= row.length) {
            return false;
        }
        int i = (l + r) / 2;

        if (target == row[i]) {
            return true;
        }

        if (target < row[i]) {
            return searchLine(row, target, l, i - 1);
        } else {
            return searchLine(row, target, i + 1, r);
        }
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        Searcha2DMatrix solution = new Searcha2DMatrix();

        boolean result = solution.searchMatrix(matrix, 16);

        System.out.println(result);
    }
}
