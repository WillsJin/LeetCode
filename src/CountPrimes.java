/**
 * Created by wills on 15/5/25.
 *
 * See https://leetcode.com/problems/count-primes/
 *
 * Author https://github.com/WillsJin
 */
public class CountPrimes
{
    public int countPrimes(int n) {

        if (n < 2) {
            return 0;
        }
        boolean[] isPrime = new boolean[n];

        for (int i = 0; i < n; i ++) {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += i)
            {
                isPrime[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i ++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        CountPrimes solution = new CountPrimes();
        long start = System.currentTimeMillis();
        int result = solution.countPrimes(15000000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(result);
    }
}
