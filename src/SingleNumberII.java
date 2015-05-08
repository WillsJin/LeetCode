import java.util.Arrays;
import java.util.Random;

/**
 * Created by wills on 15/5/8.
 *
 * See https://leetcode.com/problems/single-number-ii/
 *
 * Author https://github.com/WillsJin
 */
public class SingleNumberII
{
    public int singlenumber_simple(int[] nums) {

        int result = 0;
        for (int i = 0; i < 32; i++)
        {
            int count = 0;
            for (int num : nums)
            {
                if (((1 << i) & num) != 0)
                {
                    count++;
                }
            }
            result |= ((count % 3) << i);
        }

        return result;
    }

    /**
     * 用ones记录到当前计算的变量为止，二进制1出现“1次”（mod 3 之后的 1）的数位。用twos记录到当前计算的变量为止，二进制1出现“2次”（mod 3 之后的 2）的数位。当ones和twos中的某一位同时为1时表示二进制1出现3次，此时需要清零。即用二进制模拟三进制计算。最终ones记录的是最终结果。
     *
     * 扩展
     *
     * 扩展二: From: http://www.cnblogs.com/daijinqiao/p/3352893.html
     * 给定一个包含n个整数的数组，有一个整数x出现b次，一个整数y出现c次，其他所有的数均出现a次，其中b和c均不是a的倍数，找出x和y。使用二进制模拟a进制，累计二进制位1出现的次数，当次数达到a时，对其清零，这样可以得到b mod a次x，c mod a次y的累加。遍历剩余结果（用ones、twos、fours...变量表示）中每一位二进制位1出现的次数，如果次数为b mod a 或者 c mod a，可以说明x和y的当前二进制位不同（一个为0，另一个为1），据此二进制位将原数组分成两组，一组该二进制位为1，另一组该二进制位为0。这样问题变成“除了一个整数出现a1次（a1 = b 或 a1 = c）外所有的整数均出现a次”，使用和上面相同的方式计算就可以得到最终结果，假设模拟a进制计算过程中使用的变量为ones、twos、fours...那么最终结果可以用ones | twos | fours ...表示。
     * @param nums
     * @return
     */
    public int singlenumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums)
        {
            twos |= ones & num;
            ones ^= num;// 异或3次 和 异或 1次的结果是一样的

            //对于ones 和 twos 把出现了3次的位置设置为0 （取反之后1的位置为0）
            int threes = ~(ones & twos);
            ones &= threes;
            twos &= threes;
        }
        return ones;
    }

    public static void main(String[] args)
    {
        SingleNumberII solution = new SingleNumberII();

//        int[] arrays = new int[]{15, 59, 15, 297, 15, 297, 297, 90, 59, 59};
        int[] arrays = new int[]{2, 11, 2, 15, 2, 15, 15, 12, 11, 11};
        System.out.println(Arrays.toString(arrays));

        int result = solution.singlenumber(arrays);
        System.out.println(result);

        Random r = new Random();

        for (int i = 0; i < arrays.length; i++)
        {
            int next = r.nextInt(arrays.length);

            int t = arrays[i];
            arrays[i] = arrays[next];
            arrays[next] = t;
        }

        System.out.println(Arrays.toString(arrays));
    }

}
