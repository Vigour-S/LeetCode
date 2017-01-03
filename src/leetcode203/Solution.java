package leetcode203;

import datastructures.ListNode;

/**
 * Created by xiezhuohan on 1/3/17.
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, node = head;

        while (node != null) {
            if (node.val == val) {
                pre.next = node.next;
            } else {
                pre = pre.next;
            }
            node = node.next;
        }
        return dummy.next;
    }
}
