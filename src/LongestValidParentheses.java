import java.util.Stack;

/**
 * Created by wills on 15/9/10.
 *
 * See https://leetcode.com/problems/longest-valid-parentheses/
 *
 * It's right, but run it with a long String will be called 'Time Limit Exceeded'
 *
 * Author https://github.com/WillsJin
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {

        int start = 0, max = 0;

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.empty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    if (stack.empty()) {
                        if (max < i - start + 1) {
                            max = i - start + 1;
                        }
                    } else {
                        if (max < i - stack.peek()) {
                            max = i - stack.peek();
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

        LongestValidParentheses solution = new LongestValidParentheses();

        int result = solution.longestValidParentheses("()(()");

        System.out.println(result);
    }
}
