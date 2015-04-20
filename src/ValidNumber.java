/**
 * Created by wills on 15/4/20.
 *
 * See https://leetcode.com/problems/valid-number/
 *
 * Author https://github.com/WillsJin
 */
public class ValidNumber
{

    public boolean isNumber(String s) {

        s = s.trim();
        if (!haveNumber(s)) {
            return false;
        }

        if (s.contains("e")) {
            String[] split = s.split("e", -1);
            return split.length == 2 && haveNumber(split[0]) && allNumber(split[0]) && allNumber(split[1], true, false) && haveNumber(split[1]);
        }
        if (s.contains("."))
        {
            String[] split = s.split("\\.", -1);
            return !".".equals(s) && split.length == 2 && (allNumber(split[0]) || "".equals(split[0])) && (allNumber(split[1], false, true) || "".equals(split[1]));
        }
        return allNumber(s);
    }

    private boolean allNumber(String s, boolean lessZero, boolean contentPoint) {

        if (s.length() <= 0) {
            return false;
        }
        if (".".equals(s)) {
            return false;
        }
        if (lessZero && (s.startsWith("-") || s.startsWith("+"))) {
            s = s.substring(1);
        }
        if (contentPoint && s.contains(".")) {
            String[] split = s.split("\\.", -1);
            return split.length == 2 && (allNumber(split[0], true, false) || "".equals(split[0])) && (allNumber(split[1], false, false) || "".equals(split[1]));
        }
        for (char c : s.toCharArray()) {
            if ('0' > c || c > '9') {
                return false;
            }
        }
        return true;
    }

    private boolean allNumber(String s) {
        return allNumber(s, true, true);
    }

    private boolean haveNumber(String s) {

        for (char c : s.toCharArray()) {
            if (('0' <= c && c <= '9')) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        ValidNumber solution = new ValidNumber();
        boolean result = solution.isNumber(" 005047e+6");
        System.out.println(result);
    }
}
