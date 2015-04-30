/**
 * Created by wills on 15/4/23.
 *
 * See https://leetcode.com/problems/same-tree/
 *
 * With Public Tree Node
 *
 * Author https://github.com/WillsJin
 */
public class SameTree
{

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (null == p && null == q) {
            return true;
        }

        if (null == p || null == q) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        SameTree solution = new SameTree();

        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.left.left = new TreeNode(3);
        a.left.right = new TreeNode(4);

        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(2);
        b.left.left = new TreeNode(3);
        b.right = new TreeNode(4);

        boolean result = solution.isSameTree(a, b);
        System.out.println(result);
    }
}
