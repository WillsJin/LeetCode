/**
 * Created by wills on 15/4/16.
 *
 * See https://leetcode.com/problems/number-of-1-bits/
 *
 * Author https://github.com/WillsJin
 */
public class NumberOf1Bits
{

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        int count = 0;

        for (int i = 1; i < 33; i ++) {

            if ((n & (1 << i)) != 0) {
                count ++;
            }
        }

        return count;

    }

    public static void main(String[] args) {

        NumberOf1Bits solution = new NumberOf1Bits();
        int result = solution.hammingWeight(65536);
        System.out.println(result);
    }
}

