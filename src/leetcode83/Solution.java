package leetcode83;

import datastructures.ListNode;

/**
 * Created by xiezhuohan on 1/3/17.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        int val = head.val;
        while (node != null && node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
                val = node.val;
            }
        }
        return head;
    }
}
