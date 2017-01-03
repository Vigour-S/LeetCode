package leetcode23;

import datastructures.ListNode;

/**
 * Created by xiezhuohan on 1/2/17.
 */
/*
    If we compare the head node of each lists, the total time complexity will be O(nk)
    If we use a min-heap, the total time complexity will be O(nlogk)
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        // create a min heap. Time complexity is O(n)
        for (int i = lists.length / 2; i >=0; i--) {
            heapify(lists, i);
        }

        ListNode node = new ListNode(0);
        ListNode head = node;
        heapify(lists, 0);
        while (lists[0] != null) {
            node.next = lists[0];
            node = node.next;
            lists[0] = lists[0].next;
            heapify(lists, 0);
        }
        return head.next;
    }

    private void heapify(ListNode[] heap, int i) {
        int smallest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (heap[i] == null) {  // null is considered the biggest
            if (left < heap.length && heap[left] != null) {
                smallest = left;
            }
            if (right < heap.length && heap[left] == null && heap[right] != null) {
                smallest = right;
            }

        }
        if (left < heap.length && heap[i] != null && heap[left] != null && heap[i].val > heap[left].val) {
            smallest = left;
        }
        if (right < heap.length && heap[right] != null && heap[smallest].val > heap[right].val) {
            smallest = right;
        }

        if (smallest != i) {    // the root is not the smallest
            ListNode swap = heap[smallest];
            heap[smallest] = heap[i];
            heap[i] = swap;
            heapify(heap, smallest);
        }
    }
}
