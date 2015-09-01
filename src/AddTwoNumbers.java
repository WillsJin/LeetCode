/**
 * Created by wills on 15/9/1.
 * <p/>
 * See https://leetcode.com/problems/add-two-numbers/
 * <p/>
 * Author https://github.com/WillsJin
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node = null, root = null;
        int carry = 0;

        while (null != l1 || null != l2 || carry != 0) {
            int a = 0, b = 0;
            if (null != l1) {
                a = l1.val;
                l1 = l1.next;
            }
            if (null != l2) {
                b = l2.val;
                l2 = l2.next;
            }

            int value = a + b + carry;

            carry = value / 10;
            value = value % 10;
            if (null == node) {
                node = new ListNode(value);
                root = node;
            } else {
                node.next = new ListNode(value);
                node = node.next;
            }
        }
        return root;
    }

    public static void main(String[] args) {

        AddTwoNumbers solution = new AddTwoNumbers();

        ListNode l1 = solution.new ListNode(2);
        l1.next = solution.new ListNode(4);
        l1.next.next = solution.new ListNode(3);

        ListNode l2 = solution.new ListNode(5);
        l2.next = solution.new ListNode(6);
        l2.next.next = solution.new ListNode(4);

        l1 = solution.new ListNode(0);
        l2 = solution.new ListNode(0);

        ListNode result = solution.addTwoNumbers(l1, l2);

        if (null != result) {
            System.out.print(result.val);

            while (null != result.next) {
                result = result.next;
                System.out.print(" -> " + result.val);
            }
            System.out.println();
        }
    }

    /**
     * Definition for singly-linked list.
     */
    class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
