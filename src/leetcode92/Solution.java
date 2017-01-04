package leetcode92;

import datastructures.ListNode;

/**
 * Created by xiezhuohan on 1/3/17.
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre, node = head, end ,start = dummy, temp;
        pre = dummy;
        if (m == n || head == null) {
            return head;
        }
        int i = 0;
        while (node != null && i != m) {
            if (i == m - 2) {
                start = node;
            }
            node = node.next;
            pre = pre.next;
            i++;
        }
        end = pre;

        for (i = 0; i < n - m; i++) {
            temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        start.next = pre;
        end.next = node;

        return dummy.next;
    }
}