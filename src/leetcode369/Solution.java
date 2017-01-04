package leetcode369;

import datastructures.ListNode;

/**
 * Created by xiezhuohan on 1/4/17.
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode newHead = reverse(head, null);
        ListNode node = newHead;
        int num, carry = 0;
        if (node != null) {
            node.val++;
        }
        while (node != null) {
            num = node.val + carry;
            if (num == 10) {
                num = 0;
                carry = 1;
                node.val = 0;
            } else {
                carry = 0;
                node.val = num;
            }
            node = node.next;
        }

        if (carry == 1) {
            head = new ListNode(1);
            head.next = reverse(newHead, null);
        } else {
            head = reverse(newHead, null);
        }

        return head;
    }

    private ListNode reverse(ListNode curr, ListNode pre) {
        if (curr == null) {
            return pre;
        }
        ListNode next = curr.next;
        curr.next = pre;
        return reverse(next, curr);
    }
}
