/**
 * Created by wills on 15/4/21.
 *
 * See https://leetcode.com/problems/powx-n/
 *
 * Author https://github.com/WillsJin
 */
public class Pow
{
    private final int[] p = new int[]{0, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384,
            32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432,
            67108864, 134217728, 268435456, 536870912, 1073741824};
    public double pow(double x, int n) {

        if (x == 1.0) {
            return 1.0;
        }
        if (x == -1.0) {
            if (n % 2 == 0) {
                return 1.0;
            } else {
                return -1.0;
            }
        }
        boolean lessThanZero = false;
        if (n < 0) {
            n = -n;
            lessThanZero = true;
        }
        double[] results = new double[32];

        int i = 0;
        results[0] = 1;
        results[1] = x;
        while (p[i] < n) {
            if (i > 1) {
                results[i] = results[i - 1] * results[i - 1];
            }
            i++;
            if (i == 32) {
                i--;
                break;
            }
        }
        if (i != 0) {
            if (n != p[i]) {
                i--;
            } else if (i != 1){
                results[i] = results[i - 1] * results[i - 1];
            }
        }
        double result = 1;
        while (n != 0) {
            result *= results[i];
            n = n - p[i];
            while (p[i] > n) {
                i--;
            }
        }
        if (lessThanZero) {
            result = 1 / result;
        }
        return result;
    }

    public static void main(String[] args) {
        Pow solution = new Pow();
        double result = solution.pow(8.95371, -1);
        System.out.println(result);
    }
}
