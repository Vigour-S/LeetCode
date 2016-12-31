package leetcode143;

import datastructures.ListNode;

/**
 * Created by xiezhuohan on 12/31/16.
 */
public class Solution {
    public void reorderList(ListNode head) {
        ListNode mid, end;
        mid = head;
        end = head;
        while (end != null && end.next != null) {
            end = end.next.next;
            mid = mid.next;
        }

        ListNode right = reverse(mid, null);
        ListNode left = head;
        ListNode leftTemp, rightTemp;

        while(left != null && left.next != null) {
            if (left.next == right) {
                break;
            }
            leftTemp = left.next;
            left.next = right;
            left = leftTemp;

            rightTemp = right.next;
            right.next = left;
            right = rightTemp;
        }
    }

    private ListNode reverse(ListNode curr, ListNode prev) {
        if (curr == null)
            return prev;
        ListNode next = null;
        next = curr.next;
        curr.next = prev;
        return reverse(next, curr);
    }
}
