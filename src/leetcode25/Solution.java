package leetcode25;

import datastructures.ListNode;

/**
 * Created by xiezhuohan on 1/3/17.
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode node = head, pre;
        while (node !=null && count != k) {
            node = node.next;
            count++;
        }

        if (count == k) {
            node = reverseKGroup(node, k);
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = node;
                node = head;
                head = temp;
            }
            head = node;
        }
        return head;
    }
}
