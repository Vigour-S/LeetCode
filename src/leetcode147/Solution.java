package leetcode147;

import datastructures.ListNode;

/**
 * Created by xiezhuohan on 12/25/16.
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {

        if (head == null) return null;

        ListNode h = head;
        ListNode l1 = head.next;
        ListNode l2;

        while (l1 != null) {
            l2 = head;
            while (l2.val < l1.val && l2 != l1) {
                l2 = l2.next;
            }
            int temp = l2.val;
            int newVal = l1.val;
            while (l2 != l1) {
                l2.val = newVal;
                newVal = temp;
                l2 = l2.next;
                temp = l2.val;
            }
            l1.val = newVal;
            l1 = l1.next;
        }

        return h;
    }
}
