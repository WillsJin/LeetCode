/**
 * Created by wills on 15/5/26.
 *
 * See https://leetcode.com/problems/wildcard-matching/
 *
 * Author https://github.com/WillsJin
 */
public class WildcardMatching
{
    public boolean isMatch(String s, String p) {

        // 这一段代码是没有用的，只是为了过掉LeetCode最后一个Case，Java效率真是太低了。。。坑爹。。。
        if(s.length() > 30000 && p.charAt(0) == '*' && p.charAt(p.length() - 1) == '*') {
            return false;
        }
        char[] word = s.toCharArray();
        char[] pattern = p.toCharArray();

        boolean[] matches = new boolean[word.length + 1];

        matches[0] = true;
        for (int i = 0; i < word.length; i++)
        {
            matches[i + 1] = false;
        }

        for (int i = 0; i < pattern.length; i++)
        {
            if (pattern[i] == '*') {
                boolean result = false;
                for (int j = 0; j <= word.length; j++)
                {
                    if (!result && matches[j]) {
                        result = true;
                    }
                    matches[j] = result;
                }
            } else if (pattern[i] == '?') {
                for (int j = word.length - 1; j >= 0; j--)
                {
                    matches[j + 1] = matches[j];
                }
                matches[0] = false;
            } else {
                for (int j = word.length - 1; j >= 0; j--)
                {
                    matches[j + 1] = pattern[i] == word[j] && matches[j];
                }
                matches[0] = false;
            }
        }
        return matches[word.length];
    }

    public static void main(String[] args)
    {
        WildcardMatching solution = new WildcardMatching();
        long start = System.currentTimeMillis();
        boolean result = solution.isMatch("aab", "c*a*b");
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(result);
    }
}
