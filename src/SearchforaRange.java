import java.util.Arrays;

/**
 * Created by wills on 15/6/9.
 *
 * See https://leetcode.com/problems/search-for-a-range/
 *
 * Author https://github.com/WillsJin
 */
public class SearchforaRange
{
    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        if (nums.length <= 0 || target < nums[0] || nums[nums.length - 1] < target || (nums.length == 1 && nums[0] != target)) {
            return result;
        }

        if (nums.length == 1) {
            result[0] = 0;
            result[1] = 0;
            return result;
        }

        int l, r, i;
        // left
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            i = (l + r) / 2;
            if (target == nums[i])
            {
                if (i == 0) {
                    result[0] = i;
                    break;
                } else {
                    r = i - 1;
                }
            } else if (i + 1 < nums.length && target == nums[i + 1])
            {
                result[0] = i + 1;
                break;
            } else if (target < nums[i])
            {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

        // right
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            i = (l + r + 1) / 2;
            if (target == nums[i]) {

                if (i + 1 == nums.length) {
                    result[1] = i;
                    break;
                } else {
                    l = i + 1;
                }
            } else if (i - 1 >= 0 && nums[i - 1] == target) {
                result[1] = i - 1;
                break;
            } else if (nums[i] < target) {
                l = i + 1;
            } else {
                r = r - 1;
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        SearchforaRange solution = new SearchforaRange();
        int[] result = solution.searchRange(new int[]{1, 3}, 1);
        System.out.println(Arrays.toString(result));
    }
}
