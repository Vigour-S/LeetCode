package leetcode61;

import datastructures.ListNode;

/**
 * Created by xiezhuohan on 1/3/17.
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int count = 0;
        ListNode node = head, end, newHead;
        while (node != null) {
            node = node.next;
            count++;
        }
        node = head;
        int m = k % count;
        if (m == 0) {
            return head;
        }
        while (m != count - 1) {
            node = node.next;
            m++;
        }
        end = node;
        newHead = end.next;
        while (node != null && node.next != null) {
            node = node.next;
        }

        end.next = null;
        node.next = head;

        return newHead;
    }
}
