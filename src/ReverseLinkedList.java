/**
 * Created by wills on 15/5/18.
 *
 * See https://leetcode.com/problems/reverse-linked-list/
 *
 * Author https://github.com/WillsJin
 */
public class ReverseLinkedList
{
    public ListNode reverseList_iter(ListNode head) {

        if (null == head) {
            return null;
        }
        ListNode p = head, q = null;

        while (null != p.next) {
            ListNode t = p.next;
            p.next = q;
            q = p;
            p = t;
        }
        p.next = q;

        return p;
    }

    public ListNode reverseList(ListNode head) {

        if (null == head) {
            return null;
        }

        reverse(head);
        head.next = null;

        return newHead;
    }
    public ListNode newHead;
    public ListNode reverse(ListNode node) {

        if (null != node.next) {

            reverse(node.next).next = node;
        } else {
            newHead = node;
        }
        return node;
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
        ReverseLinkedList solution = new ReverseLinkedList();

        ListNode head = solution.new ListNode(0);
        ListNode node1 = solution.new ListNode(1);
        head.next = node1;
        ListNode node2 = solution.new ListNode(2);
        node1.next = node2;
        ListNode node3 = solution.new ListNode(3);
        node2.next = node3;
        ListNode node4 = solution.new ListNode(4);
        node3.next = node4;
        ListNode node5 = solution.new ListNode(5);
        node4.next = node5;
        ListNode node6 = solution.new ListNode(6);
        node5.next = node6;
        ListNode node7 = solution.new ListNode(7);
        node6.next = node7;
        ListNode node8 = solution.new ListNode(8);
        node7.next = node8;

        ListNode result = solution.reverseList(head);
        System.out.println(result);

    }
}
