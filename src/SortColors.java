import java.util.Arrays;

/**
 * Created by wills on 15/9/10.
 * <p/>
 * See https://leetcode.com/problems/sort-colors/
 * <p/>
 * Author https://github.com/WillsJin
 */
public class SortColors {

    public void sortColors(int[] nums) {

        int i0 = 0, i1 = 0, i2 = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                i0++;
            } else if (nums[i] == 1) {
                i1++;
            } else if (nums[i] == 2) {
                i2++;
            }
        }
        int i = 0;
        for (; i < i0; i++) {
            nums[i] = 0;
        }
        for (; i < i0 + i1; i++) {
            nums[i] = 1;
        }
        for (; i < i0 + i1 + i2; i++) {
            nums[i] = 2;
        }
    }

    public static void main(String[] args) {

        SortColors solution = new SortColors();

        int[] nums = new int[]{1, 2, 2, 2, 2, 1, 1, 1, 1, 0, 1, 0, 1, 1, 2, 2, 2, 1, 1, 0};

        System.out.println(Arrays.toString(nums));
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
