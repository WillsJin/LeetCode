/**
 * Created by wills on 15/5/12.
 *
 * See https://leetcode.com/problems/excel-sheet-column-title/
 *
 * Author https://github.com/WillsJin
 */
public class ExcelSheetColumnTitle
{
    public String convertToTitle(int n) {

        char[] list = new char[10];
        int i = 0;
        do {
            int t = n % 26;
            n = n / 26;
            if (t == 0) {
                n--;
                t = 26;
            }
            list[i++] = (char) (t + 'A' - 1);
        } while (n > 0);

        String s = "";
        while (i-- > 0) {
            s += list[i];
        }
        return s;
    }

    public static void main(String[] args)
    {
        ExcelSheetColumnTitle solution = new ExcelSheetColumnTitle();
        String result = solution.convertToTitle(52);
        System.out.println(result);
    }
}
