package leetcode234;

import datastructures.ListNode;

/**
 * Created by xiezhuohan on 1/2/17.
 */
/*
    O(1) space, O(n) time
 */

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode node = head, post, fast = head;

        while (node != null && fast != null && fast.next != null) {
            fast = fast.next.next;
            post = node.next;
            node.next = pre;
            pre = node;
            node = post;
        }

        if (fast != null) {
            node = node.next;
        }

        while (node != null) {
            if (node.val != pre.val) {
                return false;
            }
            node = node.next;
            pre = pre.next;
        }
        return true;
    }
}
