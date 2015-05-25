import java.util.ArrayList;
import java.util.List;

/**
 * Created by wills on 15/5/22.
 *
 * See http://www.matrix67.com/blog/archives/333
 *
 * 字符串的相似度 字典结构。
 */
public class _Other2
{
    private _Other2() {}
    private static class _Other2Loader {

        private static final _Other2 instance = new _Other2();
    }
    public static _Other2 getInstance() {
        return _Other2Loader.instance;
    }

    private final int MAX_WORD_LENGTH = 6;

    Tree directory;
    class Tree {
        String value;
        Tree[] children;
        Tree(String value) {
            this.value = value;
            this.children = new Tree[MAX_WORD_LENGTH];
        }
    }

    public int getSimilarity(String s1, String s2) {

        int[][] status = new int[s1.length() + 1][s2.length() + 1];
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        status[0][0] = 0;
        for (int i = 1; i <= s1.length(); i++) {
            status[i][0] = i;
        }
        for (int j = 1; j <= s2.length(); j++) {
            status[0][j] = j;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {

                if (c1[i - 1] == c2[j - 1]) {
                    status[i][j] = status[i - 1][j - 1];
                } else {
                    int min = status[i - 1][j];
                    if (status[i][j - 1] < min) {
                        min = status[i][j - 1];
                    }
                    if (status[i - 1][j] < min) {
                        min = status[i - 1][j];
                    }
                    if (status[i - 1][j - 1] < min) {
                        min = status[i - 1][j - 1];
                    }
                    status[i][j] = min + 1;
                }
            }
        }

        return status[s1.length()][s2.length()];
    }

    public Tree setWord(String word) {

        if (null != word && !"".equals(word))
        {
            if (null == directory)
            {
                directory = new Tree(word);
            } else {
                Tree node = directory;
                int key;
                while (true) {
                    key = getSimilarity(word, node.value);
                    Tree children = node.children[key];
                    if (null == children) {
                        break;
                    } else {
                        node = children;
                    }
                }
                node.children[key] = new Tree(word);
            }
        }
        return directory;
    }

    public void findWords(List<String> result, Tree node, String word, int distance) {

        if (null == result) {
            return;
        }
        if (null == node) {
            return;
        }

        int key = getSimilarity(node.value, word);

        if (key <= distance) {
            result.add(node.value);
        }
        int min = distance - key;
        int max = distance + key;
        if (min < 0) {
            min = 0;
        }
        if (max >= MAX_WORD_LENGTH) {
            max = MAX_WORD_LENGTH - 1;
        }

        for (int i = min; i <= max; i++) {

            findWords(result, node.children[i], word, distance);
        }

    }

    public static void main(String[] args)
    {
        getInstance().setWord("GAME");
        getInstance().setWord("FAME");
        getInstance().setWord("GATE");
        getInstance().setWord("AIM");
        getInstance().setWord("GAIN");
        getInstance().setWord("FRAME");
        getInstance().setWord("SAME");
        getInstance().setWord("ACM");
        getInstance().setWord("HOME");
        getInstance().setWord("GAY");

        List<String> result = new ArrayList<String>();
        getInstance().findWords(result, getInstance().directory, "GAIE", 1);
        System.out.println(result);
    }
}
