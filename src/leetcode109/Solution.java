package leetcode109;

import datastructures.ListNode;
import datastructures.TreeNode;

/**
 * Created by xiezhuohan on 1/3/17.
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode end) {
        ListNode fast = head, mid = head;
        if (head == null || head == end) {
            return null;
        }
        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            mid = mid.next;
        }
        TreeNode root = new TreeNode(mid.val);
        root.left = helper(head, mid);
        root.right = helper(mid.next, end);


        return root;
    }
}