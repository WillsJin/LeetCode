import java.util.Arrays;

/**
 * Created by wills on 15/9/1.
 * <p/>
 * See https://leetcode.com/problems/plus-one/
 * <p/>
 * Author https://github.com/WillsJin
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {

        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {

            int c;
            if (i == digits.length - 1) {
                c = digits[i] + 1 + carry;
            } else {
                c = digits[i] + carry;
            }
            carry = c / 10;
            digits[i] = c % 10;
        }

        if (carry != 0) {
            int[] result = new int[digits.length + 1];

            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = carry;

            return result;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {

        PlusOne solution = new PlusOne();

        int[] digits = new int[]{9, 9, 9, 9, 9, 9};

        int[] result = solution.plusOne(digits);

        System.out.println(Arrays.toString(result));
    }
}
