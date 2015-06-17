import java.util.Arrays;
import java.util.Stack;

/**
 * Created by wills on 15/6/5.
 *
 * See https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Author https://github.com/WillsJin
 */
public class LargestRectangleinHistogram
{
    public int largestRectangleArea(int[] height) {

        if (null == height || height.length <= 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int[] h = Arrays.copyOf(height, height.length + 1);
        int i = 0;
        int max = 0;
        while (i < h.length) {
            if (stack.empty() || h[stack.peek()] <= h[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                int length;
                if (stack.empty()) {
                    length = i; // i绝逼是有史以来最短的一条
                } else {
                    length = i - stack.peek() - 1;
                }
                int area = length * h[t];
                if (max < area) {
                    max = area;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleinHistogram solution = new LargestRectangleinHistogram();
        int result = solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        System.out.println(result);
    }
}
