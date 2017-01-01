package leetcode148;

import datastructures.ListNode;

/**
 * Created by xiezhuohan on 12/31/16.
 */

/*
    Using merge sort to sort a list
    The difficult part is merging
    The merging code I wrote first is not concise
 */
public class Solution {
    public ListNode sortList(ListNode head) {

        ListNode end = head;
        while (end != null && end.next != null) {
            end = end.next;
        }
        return mergeSort(head, end);
    }

    private ListNode mergeSort(ListNode start, ListNode end) {

        if (start == end) {
            return start;
        }

        ListNode mid = start, fast = start;
        while(fast != end && fast.next != end) {
            mid = mid.next;
            fast = fast.next.next;
        }
        ListNode newStart = mid.next; mid.next = null;
        ListNode left = mergeSort(start, mid);
        ListNode right = mergeSort(newStart, end);

        ListNode leftTemp, rightTemp, head = left;

//        if (left.val > right.val) {
//            head = right;
//        }

        // below is the code I initially wrote, it is too redundant
//        while (left != null && right != null) {
//            leftTemp = left.next;
//            rightTemp = right.next;
//
//            if (left.val <= right. val) {
//                while (left.next != null && left.next.val <= right.val) {
//                    left = left.next;
//                    leftTemp = left.next;
//                }
//                left.next = right;
//                left = leftTemp;
//            } else {
//                while (right.next != null && right.next.val <= left.val) {
//                    right = right.next;
//                    rightTemp = right.next;
//                }
//                right.next = left;
//                right = rightTemp;
//            }
//        }

        // below is the better way to merge two lists

        ListNode pre = new ListNode(0), dummy = pre;
        while (left != null && right != null) {
            if (left.val < right.val) {
                pre.next = left;
                left = left.next;
            } else {
                pre.next = right;
                right= right.next;
            }
            pre = pre.next;
        }
        if (left != null) {
            pre.next = left;
        }
        if (right != null) {
            pre.next = right;
        }

        return dummy.next;
    }
}
