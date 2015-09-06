/**
 * Created by wills on 15/9/2.
 * <p/>
 * See https://leetcode.com/problems/reverse-integer/
 * <p/>
 * Author https://github.com/WillsJin
 */
public class ReverseInteger {

    public int reverse(int x) {

        int negative = 1;
        if (x < 0) {
            negative = -1;
            x = -x;
        }

        int result = 0;

        while (x > 0) {
            // 只要处理一下这个越界问题就好啦～
            if (result > Integer.MAX_VALUE / 10 || ((result == Integer.MAX_VALUE / 10) && x % 10 == Integer.MAX_VALUE % 10)) {
                return 0;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }

        return result * negative;
    }

    public static void main(String[] args) {

        ReverseInteger solution = new ReverseInteger();
        int result = solution.reverse(2147483647);
        System.out.println(result);

        System.out.println(Integer.MAX_VALUE);
    }
}
