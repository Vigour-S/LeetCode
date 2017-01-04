package leetcode82;

import datastructures.ListNode;

/**
 * Created by xiezhuohan on 1/4/17.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode pre = dummy, node = head;
        dummy.next = head;

        while (node != null && node.next != null) {
            if (node.next.val == node.val) {
                while (node.next != null && node.next.val == node.val) {
                    node = node.next;
                }
                node = node.next;
                pre.next = node;
            } else {
                pre = node;
                node = node.next;
            }
        }

        return dummy.next;
    }
}
