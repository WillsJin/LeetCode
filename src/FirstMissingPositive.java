/**
 * Created by wills on 15/9/1.
 * <p/>
 * See https://leetcode.com/problems/plus-one/
 * <p/>
 * Author https://github.com/WillsJin
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        int i = 0, n = nums.length;
        while (i < n) {
            if (nums[i] != i + 1 && 1 <= nums[i] && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {

                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {

        FirstMissingPositive solution = new FirstMissingPositive();

        int result = solution.firstMissingPositive(new int[]{3, 4, -1, 1});
        System.out.println(result);
    }
}
