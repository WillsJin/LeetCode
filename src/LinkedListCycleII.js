/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */

function ListNode(val) {
    this.val = val;
    this.next = null;
}
var detectCycle = function(head) {

    var p, q;
    p = q = head;

    var flag = false;

    while (p != null && p.next != null && q.next != null && q.next.next != null) {
        p = p.next;
        q = q.next.next;

        if (p == q) {
            flag = true;
            break;
        }
    }

    if (!flag) {
        return null;
    }

    p = head;

    while (p != q) {
        p = p.next;
        q = q.next;
    }
    return p;
};

var head = new ListNode(1);

var node1 = new ListNode(2);
head.next = node1;

var node2 = new ListNode(3);
node1.next = node2;

var node3 = new ListNode(4);
node2.next = node3;

var node4 = new ListNode(5);
node3.next = node4;

var node5 = new ListNode(6);
node4.next = node5;

var node6 = new ListNode(7);
node5.next = node6;

var node7 = new ListNode(8);
node6.next = node7;

node7.next = node4;

var result = detectCycle(head);

console.log(result);
