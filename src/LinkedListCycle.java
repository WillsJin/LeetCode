/**
 * Created by wills on 15/4/27.
 *
 * See https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * Author https://github.com/WillsJin
 */
public class LinkedListCycle
{
    public boolean hasCycle(ListNode head) {

        ListNode p, q;

        p = q = head;
        while (null != p && null != p.next && null != q.next && null != q.next.next) {

            p = p.next;
            q = q.next.next;

            if (p.equals(q)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

        LinkedListCycle solution = new LinkedListCycle();

        ListNode head = solution.new ListNode(0);
        ListNode node = head;

        node.next = solution.new ListNode(1);
        node = node.next;
        node.next = solution.new ListNode(2);
        node = node.next;
        node.next = solution.new ListNode(3);
        node = node.next;
        node.next = solution.new ListNode(4);
        node = node.next;
        node.next = solution.new ListNode(5);
        node = node.next;
        ListNode cycle = node;
        node.next = solution.new ListNode(6);
        node = node.next;
        node.next = solution.new ListNode(7);
        node = node.next;
        node.next = solution.new ListNode(8);
        node = node.next;
        node.next = solution.new ListNode(9);
        node = node.next;

        node.next = cycle;

        boolean result = solution.hasCycle(head);
        System.out.println(result);
    }
}
