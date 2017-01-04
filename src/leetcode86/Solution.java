package leetcode86;

import datastructures.ListNode;

/**
 * Created by xiezhuohan on 1/3/17.
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode smaller = head, bigger = head, smallerHead, biggerHead, node;
        if (head == null) {
            return head;
        }
        if (head.val < x) {
            smallerHead = head;
            while (smaller.next !=null && smaller.next.val < x) {
                smaller = smaller.next;
            }
            biggerHead = smaller.next;
            bigger = biggerHead;
            if (biggerHead == null) {
                return smallerHead;
            } else {
                node = biggerHead.next;
            }

        } else {
            biggerHead = head;
            while (bigger.next !=null && bigger.next.val >= x) {
                bigger = bigger.next;
            }
            smallerHead = bigger.next;
            smaller = smallerHead;
            if (smallerHead == null) {
                return biggerHead;
            } else {
                node = smallerHead.next;
            }
        }

        while (node != null) {
            if (node.val < x) {
                smaller.next = node;
                smaller = smaller.next;
            } else {
                bigger.next = node;
                bigger = bigger.next;
            }
            node = node.next;
        }

        smaller.next = biggerHead;
        bigger.next = null;

        return smallerHead;
    }
}
