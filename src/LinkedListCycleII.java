/**
 * Created by wills on 15/4/27.
 *
 * See https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * See LinkedListCycleII.jpg
 * From http://www.cnblogs.com/hiddenfox/p/3408931.html
 * 说明：慢一点的节点走的路程：a + b，快一些的节点走的路程：a + b + c + b;
 * 由于 2 * 慢一点的节点走的路程 = 快一些的节点走的路程，得 2 * (a + b) = a + b + c + b;
 * 结论：a = c。(Important)!
 *
 * 因而，一个指针从第一次相遇得节点开始走，另一个从起点开始走，第一次相遇即为环中第一个节点。
 *
 * PS: 这个程序没有问题，提交以后超时，大概是Java的原因，实用JavaScript语言之后，Accepted.
 *
 * Author https://github.com/WillsJin
 *
 */
public class LinkedListCycleII
{
    public ListNode detectCycle(ListNode head) {

        ListNode p, q;

        p = q = head;

        boolean flag = false;
        while (null != p && null != p.next && null != q.next && null != q.next.next) {

            p = p.next;
            q = q.next.next;

            if (p.equals(q)) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            return null;
        }
        p = head;

        while (!p.equals(q)) {
            p = p.next;
            q = q.next;
        }

        return p;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        ListNode node = head;

        node.next = new ListNode(1);
        node = node.next;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(5);
        node = node.next;
        ListNode cycle = node;
        node.next = new ListNode(6);
        node = node.next;
        node.next = new ListNode(7);
        node = node.next;
        node.next = new ListNode(8);
        node = node.next;
        node.next = new ListNode(9);
        node = node.next;

        node.next = cycle;

        head = new ListNode(3);
        node = head;

        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(0);
        node = node.next;
        node.next = new ListNode(-4);
        node = node.next;
        node.next = head;

        LinkedListCycleII solution = new LinkedListCycleII();
        ListNode result = solution.detectCycle(head);
        System.out.println(result.val);
    }
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
 *
 * Use LinkedListCycle.java's ListNode
 */