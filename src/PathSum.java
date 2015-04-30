/**
 * Created by wills on 15/4/27.
 *
 * See https://leetcode.com/problems/path-sum/
 *
 * Author https://github.com/WillsJin
 */
public class PathSum
{
    public boolean hasPathSum(TreeNode root, int sum)
    {
        return null != root && ((sum == root.val && null == root.left && null == root.right) || hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
    }

    public static void main(String[] args) {

        TreeNode leaf = new TreeNode(11);
        leaf.left = new TreeNode(7);
        leaf.right = new TreeNode(2);

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = leaf;

        leaf = new TreeNode(8);
        leaf.left = new TreeNode(13);
        leaf.right = new TreeNode(4);
        leaf.right.right = new TreeNode(1);

        root.right = leaf;

        PathSum solution = new PathSum();
        boolean result = solution.hasPathSum(root, 22);

        System.out.println(result);
    }
}
