/**
 * Created by wills on 15/4/27.
 *
 * See https://leetcode.com/problems/longest-common-prefix/
 *
 * Author https://github.com/WillsJin
 */
public class LongestCommonPrefix
{

    public String longestCommonPrefix(String[] strs) {

        if (null == strs) {
            return null;
        } else if (strs.length <= 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }

        String result = strs[0];

        for (int i = 1; i < strs.length; i++) {

            String item = strs[i];

            int less = result.length();
            if (less > item.length()) {
                less = item.length();
            }

            int j = 0;
            for (; j < less; j++) {
                if (result.charAt(j) != item.charAt(j)) {
                    break;
                }
            }
            result = result.substring(0, j);
        }

        return result;
    }

    public static void main(String[] args) {

        LongestCommonPrefix solution = new LongestCommonPrefix();
        String[] strs = new String[]{"abc", "abde", "abd"};
        String result = solution.longestCommonPrefix(strs);

        System.out.println(result);
    }
}
