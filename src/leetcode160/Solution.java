package leetcode160;

import datastructures.ListNode;

/**
 * Created by xiezhuohan on 1/1/17.
 */

/*
    This solution works in O(n) time and O(1) space
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;

        if (l1 == null || l2 == null) {
            return null;
        }
        while (l1 != l2) {
            if (l1 == null) {
                l1 = headB;
            } else {
                l1 = l1.next;
            }
            if (l2 == null) {
                l2 = headA;
            }  else {
                l2 = l2.next;
            }
        }

        return l1;
    }
}
