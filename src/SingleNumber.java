/**
 * Created by wills on 15/4/16.
 *
 * See https://leetcode.com/problems/single-number/
 *
 * Author https://github.com/WillsJin
 */
public class SingleNumber
{

    public int singleNumber(int[] A) {

        int count = 0;

        for (int i = 0; i < A.length; i++) {
            count ^= A[i];
        }

        return count;
    }

    public static void main(String[] args) {

        SingleNumber solution = new SingleNumber();
        int result = solution.singleNumber(new int[]{1, 3, 1, 123, 3});
        System.out.println(result);
    }
}
