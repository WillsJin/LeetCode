import java.util.Arrays;
import java.util.List;

/**
 * Created by wills on 15/4/17.
 *
 * See https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * Author https://github.com/WillsJin
 */
public class FindMinimuminRotatedSortedArray
{

    public int findMin(List<Integer> nums) {

        if (nums == null || nums.size() <= 0) {
            return 0;
        }
        int i = 0, j = nums.size() - 1;

        if (nums.get(i) < nums.get(j)) {
            return nums.get(i);
        }

        while (i + 1 < j) {

            int k = (i + j) / 2;

            if (nums.get(i) > nums.get(k)) {
                j = k;
            } else {
                i = k;
            }
        }

        return nums.get(j);

    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2);

        FindMinimuminRotatedSortedArray solution = new FindMinimuminRotatedSortedArray();
        int result = solution.findMin(list);

        System.out.println(result);

    }
}
