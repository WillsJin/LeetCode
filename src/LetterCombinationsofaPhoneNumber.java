import java.util.*;

/**
 * Created by wills on 15/6/1.
 *
 * See https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Author https://github.com/WillsJin
 */
public class LetterCombinationsofaPhoneNumber
{
    private static Map<Character, List<Character>> characterListMap = new HashMap<Character, List<Character>>();

    static {
        characterListMap.put('2', Arrays.asList('a', 'b', 'c'));
        characterListMap.put('3', Arrays.asList('d', 'e', 'f'));
        characterListMap.put('4', Arrays.asList('g', 'h', 'i'));
        characterListMap.put('5', Arrays.asList('j', 'k', 'l'));
        characterListMap.put('6', Arrays.asList('m', 'n', 'o'));
        characterListMap.put('7', Arrays.asList('p', 'q', 'r', 's'));
        characterListMap.put('8', Arrays.asList('t', 'u', 'v'));
        characterListMap.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {

        List<String> root = new ArrayList<String>();
        if (null != digits && digits.length() > 0) {
            root.add("");
            for (char c : digits.toCharArray()) {
                List<String> leaf = new ArrayList<String>();
                List<Character> charList = characterListMap.get(c);

                if (null != charList) {
                    for (String prefix : root) {
                        for (Character cs : charList) {
                            leaf.add(prefix + cs);
                        }
                    }
                    root = leaf;
                }
            }
        }
        return root;
    }

    public static void main(String[] args)
    {
        LetterCombinationsofaPhoneNumber solution = new LetterCombinationsofaPhoneNumber();
        List<String> result = solution.letterCombinations("23");
        System.out.println(result);
    }
}
