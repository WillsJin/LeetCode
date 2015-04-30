/**
 * Created by wills on 15/4/28.
 *
 * 另一个问题：
 * 给一个数组a, 求max(a[i] - a[j]), i < j
 */
public class _Other1
{
    public int getMax(int[] a) {

        int min = a[0];
        if (min > a[1]) {
            min = a[1];
        }

        int value = a[1] - a[0];

        for (int i = 2; i < a.length; i++) {
            if (value < a[i] - min) {
                value = a[i] - min;
            }
            if (min > a[i]) {
                min = a[i];
            }
        }

        return value;
    }

    public static void main(String[] args) {

        _Other1 solution = new _Other1();
        int[] a = new int[]{5, 6, 7, 4, 5, 6, 7, 8, 9, 3, 4, 5, 6};
        int result = solution.getMax(a);
        System.out.println(result);
    }
}
