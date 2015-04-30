import java.util.ArrayList;
import java.util.List;

/**
 * Created by wills on 15/4/27.
 *
 * See https://leetcode.com/problems/path-sum-ii/
 *
 * Author https://github.com/WillsJin
 */
public class PathSumII
{
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private List<Integer> path = new ArrayList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (null == root) {
            return result;
        }

        path.add(root.val);
        int index = path.size() - 1;
        if (sum == root.val && null == root.left && null == root.right) {

            result.add(new ArrayList<Integer>(path));
        }

        pathSum(root.left, sum - root.val);
        pathSum(root.right, sum - root.val);

        path.remove(index);

        return result;
    }

    public static void main(String[] args)
    {
        TreeNode leaf = new TreeNode(11);
        leaf.left = new TreeNode(7);
        leaf.right = new TreeNode(2);
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = leaf;
        leaf = new TreeNode(8);
        leaf.left = new TreeNode(13);
        leaf.right = new TreeNode(4);
        leaf.right.left = new TreeNode(5);
        leaf.right.right = new TreeNode(1);
        root.right = leaf;
        PathSumII solution = new PathSumII();
        List<List<Integer>> result = solution.pathSum(root, 22);
        System.out.println(result);
    }
}
