/**
 * Created by wills on 16/4/12.
 */
public class Searcha2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length > 0 && matrix[0].length > 0) {
            if (matrix[0][0] <= target && target <= matrix[matrix.length - 1][matrix[matrix.length - 1].length - 1]) {

                int maxRowNumber = searchRowLeft(matrix, target, 0, matrix.length);
                int minRowNumber = searchRowRight(matrix, target, 0, matrix.length);

                for (int i = minRowNumber; i <= maxRowNumber; i++) {
                    if (searchLine(matrix[i], target, 0, matrix[i].length)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int searchRowLeft(int[][] matrix, int target, int l, int r) {

        int i = (l + r) / 2;

        if (target < matrix[i][0]) {
            return searchRowLeft(matrix, target, l, i);
        }

        if (i + 1 < matrix.length) {

            if (matrix[i][0] <= target && target < matrix[i + 1][0]) {
                return i;
            } else {
                return searchRowLeft(matrix, target, i, r);
            }
        } else {
            return i;
        }
    }

    private int searchRowRight(int[][] matrix, int target, int l, int r) {

        int i = (l + r) / 2;

        if (matrix[i][matrix[i].length - 1] < target) {
            return searchRowRight(matrix, target, i, r);
        }

        if (i > 0) {

            if (target <= matrix[i][matrix[i].length - 1] && matrix[i - 1][matrix[i].length - 1] < target) {
                return i;
            } else {
                return searchRowRight(matrix, target, l, i);
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
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        matrix = new int[][]{
                {-1},
                {-1}
        };

        Searcha2DMatrixII solution = new Searcha2DMatrixII();

        boolean result = solution.searchMatrix(matrix, -1);

        System.out.println(result);
    }
}
