
/**
 * 给定一个字符串，要求将字符串前面的若干个字符移动到字符串的尾部。
 * eg: 将abcdef的前3个字符a, b, c 移动到字符串的尾部
 * 原来字符串将变为defabc
 * PS: 要求空间复杂度为O(1), 时间复杂度为O(n)
 * <p/>
 * Created by wills on 16/3/11.
 */
public class _StringConcat {

    public String concat(String code, int n) {

        if (null == code || n <= 0 || code.length() <= n) {
            return code;
        }
        char[] chars = code.toCharArray();
        int length = chars.length;

        int times;
        int defaultLength;

        int gcd = gcd(length, n);
        if (gcd != 1) {
            times = gcd;
            defaultLength = length / gcd - 1;
        } else {
            times = 1;
            defaultLength = length - 1;
        }

        for (int m = 0; m < times; m++) {
            int i = m;
            char t = chars[i];
            int p = defaultLength;
            while (p-- > 0) {
                int j = (i + n) % length;
                chars[i] = chars[j];
                i = j;
            }
            chars[i] = t;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String result = new _StringConcat().concat("abcdef", 4);
        System.out.println(result);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
