/**
 * Created by wills on 15/5/19.
 *
 * See https://leetcode.com/problems/reverse-linked-list-ii/
 *
 * Author https://github.com/WillsJin
 */
public class ReverseLinkedListII
{

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (null == head) {
            return null;
        }

        int i = 1;
        ListNode prefix = null, p = head;

        while (i < m) {
            prefix = p;
            p = p.next;
            i++;
        }
        ListNode end = p;
        ListNode q = null;

        while (i < n) {
            ListNode t = p.next;
            p.next = q;
            q = p;
            p = t;
            i++;
        }
        if (null == prefix) {
            head = p;
        } else {
            prefix.next = p;
        }
        end.next = p.next;
        if (n != m) {
            p.next = q;
        }

        return head;
    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args)
    {

        ReverseLinkedListII solution = new ReverseLinkedListII();

        ListNode node1 = solution.new ListNode(1);
        ListNode node2 = solution.new ListNode(2);
        node1.next = node2;
        ListNode node3 = solution.new ListNode(3);
        node2.next = node3;
        ListNode node4 = solution.new ListNode(4);
        node3.next = node4;
        ListNode node5 = solution.new ListNode(5);
        node4.next = node5;

        ListNode result = solution.reverseBetween(node1, 2, 4);

        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
        System.out.println("NULL");

    }
}
