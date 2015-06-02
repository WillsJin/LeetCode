/**
 * Created by wills on 15/6/1.
 *
 * See https://leetcode.com/problems/add-binary/
 *
 * Author https://github.com/WillsJin
 */
public class AddBinary
{
    public String addBinary(String a, String b) {

        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        for (int i = 0; i < c1.length / 2; i++)
        {
            char c = c1[i];
            c1[i] = c1[c1.length - i - 1];
            c1[c1.length - i - 1] = c;
        }
        for (int i = 0; i < c2.length / 2; i++)
        {
            char c = c2[i];
            c2[i] = c2[c2.length - i - 1];
            c2[c2.length - i - 1] = c;
        }

        int length = c1.length;
        if (length < c2.length) {
            length = c2.length;
        }
        char result[] = new char[length + 1];

        int carry = 0;
        for (int i = 0; i < length; i++)
        {
            int w1, w2;
            if (i < c1.length) {
                w1 = c1[i] - '0';
            } else {
                w1 = 0;
            }
            if (i < c2.length) {
                w2 = c2[i] - '0';
            } else {
                w2 = 0;
            }

            int add = w1 + w2 + carry;

            result[i] = (char) (add % 2 + '0');

            carry = add / 2;
        }
        if (carry != 0) {
            result[length] = (char) (carry + '0');
        }

        for (int i = 0; i < result.length / 2; i++)
        {
            char c = result[i];
            result[i] = result[result.length - i - 1];
            result[result.length - i - 1] = c;
        }

        // 这里总是出问题，我用new String(result)就是不行，简直是日了狗了。
        StringBuilder sb = new StringBuilder();
        for (char c : result)
        {
            if (c != 0)
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        AddBinary solution = new AddBinary();
        String result = solution.addBinary("0", "0");
        System.out.println(result);
    }
}
