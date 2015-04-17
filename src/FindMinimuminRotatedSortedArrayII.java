import java.util.Arrays;
import java.util.List;

/**
 * Created by wills on 15/4/17.
 *
 * See https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * Author https://github.com/WillsJin
 */
public class FindMinimuminRotatedSortedArrayII
{

    public int findMin(List<Integer> nums) {

        int min = 0;
        if (nums == null || nums.size() <= 0) {
            return min;
        }

        min = nums.get(0);
        for (Integer i : nums) {
            if (i < min) {
                min = i;
            }
        }
        return min;

    }

    public static void main(String[] args) {

        // Exception
        List<Integer> list = Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 0, 1, 2, 5);

        FindMinimuminRotatedSortedArrayII solution = new FindMinimuminRotatedSortedArrayII();
        int result = solution.findMin(list);

        System.out.println(result);

    }
}
