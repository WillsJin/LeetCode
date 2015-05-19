import java.util.HashMap;
import java.util.Map;

/**
 * Created by wills on 15/4/27.
 *
 * See https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * Author https://github.com/WillsJin
 */
public class CopyListwithRandomPointer
{
    private Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

    public RandomListNode copyRandomList(RandomListNode head) {

        if (null == head) {
            return null;
        }
        if (map.keySet().contains(head))
        {
            return map.get(head);
        }

        RandomListNode node = new RandomListNode(head.label);

        map.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }

    /**
     * Definition for singly-linked list with a random pointer.
     * class RandomListNode {
     *     int label;
     *     RandomListNode next, random;
     *     RandomListNode(int x) { this.label = x; }
     * };
     */
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public static void main(String[] args) {

        CopyListwithRandomPointer solution = new CopyListwithRandomPointer();

        RandomListNode head = solution.new RandomListNode(-1);
        RandomListNode node0 = solution.new RandomListNode(0);
        RandomListNode node1 = solution.new RandomListNode(1);
        RandomListNode node2 = solution.new RandomListNode(2);

        head.next = node0;
        node0.next = node1;
        node1.next = node2;

        head.random = node2;
        node0.random = node1;
        node1.random = head;
        node2.random = node0;

        RandomListNode copy = solution.copyRandomList(head);

        System.out.println(copy);
    }
}
