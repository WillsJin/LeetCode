/**
 * Created by wills on 15/5/12.
 *
 * See https://leetcode.com/problems/excel-sheet-column-number/
 *
 * Author https://github.com/WillsJin
 */
public class ExcelSheetColumnNumber
{
    public int titleToNumber(String s) {

        char[] chars = s.toCharArray();

        int total = 0;
        for (char c : chars)
        {
            total *= 26;
            total += c - 'A' + 1;
        }
        return total;
    }

    public static void main(String[] args)
    {
        ExcelSheetColumnNumber solution = new ExcelSheetColumnNumber();
        int result = solution.titleToNumber("AB");
        System.out.println(result);
    }
}
