import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wills on 15/6/16.
 * <p/>
 * See https://leetcode.com/problems/two-sum/
 * <p/>
 * Author https://github.com/WillsJin
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(target - nums[i])) {
                result[0] = indexMap.get(target - nums[i]) + 1;
                result[1] = i + 1;
                break;
            } else {
                indexMap.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] result = solution.twoSum(new int[]{2, 7, 11, 4, 15}, 8);
        System.out.println(Arrays.toString(result));
    }
}
