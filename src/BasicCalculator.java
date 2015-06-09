import java.util.Stack;

/**
 * Created by wills on 15/6/9.
 *
 * See https://leetcode.com/problems/basic-calculator/
 *
 * Author https://github.com/WillsJin
 */
public class BasicCalculator
{
    public int calculate(String s) {

        Stack<Object> stack = new Stack<Object>();

        int i = 0;
        char[] chars = s.replace(" ", "").toCharArray();
        while (i < chars.length) {

            if (chars[i] == '(' || chars[i] == '+' || chars[i] == '-') {
                stack.push(chars[i]);
                i++;
                continue;
            }
            int number = 0;
            if ('0' <= chars[i] && chars[i] <= '9') {
                while (i < chars.length && '0' <= chars[i] && chars[i] <= '9') {
                    number = number * 10 + chars[i] - '0';
                    i++;
                }
                i--;
            }
            if (chars[i] == ')') {
                number = (Integer) stack.pop();
                stack.pop();// 这个一定会是'(', 否则算是错误
            }
            if (!stack.empty()) {
                Object top = stack.peek();
                if (top instanceof Character && ((Character) top == '+' || (Character) top == '-')) {
                    Character c = (Character) stack.pop();
                    Integer operation = (Integer) stack.pop();
                    if (c == '+') {
                        number = number + operation;
                    } else {
                        number = operation - number;
                    }
                }
            }
            stack.push(number);

            i++;
        }
        if (stack.empty()) {
            return 0;
        } else {
            return (Integer) stack.pop();
        }
    }

    public static void main(String[] args)
    {
        BasicCalculator solution = new BasicCalculator();
        int result = solution.calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(result);
    }
}
