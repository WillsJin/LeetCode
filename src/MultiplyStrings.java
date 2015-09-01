/**
 * Created by wills on 15/9/1.
 * <p/>
 * See https://leetcode.com/problems/multiply-strings/
 * <p/>
 * Author https://github.com/WillsJin
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {

        int[] array1 = getAddArray(num1);
        int[] array2 = getAddArray(num2);

        int[] count = new int[array1.length * array2.length + 1];

        for (int i = 0; i < array1.length; i++) {
            int carry = 0;
            int[] add = new int[array2.length + 1];
            for (int j = 0; j < array2.length + 1; j++) {

                int b = 0;
                if (j < array2.length) {
                    b = array2[j];
                }
                int c = array1[i] * b + carry;
                carry = c / 10;
                add[j] = c % 10;
            }

            carry = 0;
            for (int j = 0; j < array2.length + 1; j++) {
                int c = count[j + i] + add[j] + carry;
                carry = c / 10;
                count[j + i] = c % 10;
            }
        }

        int length = count.length;
        while (count[length - 1] == 0 && length > 1) {
            length--;
        }
        char[] result = new char[length];

        for (int i = 0; i < length; i++) {
            result[i] = (char) (count[length - 1 - i] + '0');
        }

        return new String(result);
    }

    public int[] getAddArray(String string) {

        char[] chars = string.toCharArray();

        int[] array = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            array[i] = chars[chars.length - 1 - i] - '0';
        }

        return array;
    }

    public static void main(String[] args) {

        MultiplyStrings solution = new MultiplyStrings();

        String result = solution.multiply("99", "9");
        System.out.println(result);
    }
}
