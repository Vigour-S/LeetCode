package leetcode116;

import datastructures.TreeLinkNode;

/**
 * Created by xiezhuohan on 12/30/16.
 */

// This is not the best solution
public class Solution {
    public void connect(TreeLinkNode root) {
        helper(root);
    }

    private void helper(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null) {
            return;
        }

        if (root.left != null) {
            root.left.next = root.right;
        }

        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;

        if (left !=null) {
            while (left.right != null) {
                left.right.next = right.left;
                left = left.right;
                right = right.left;
            }
        }
        helper(root.left);
        helper(root.right);
    }
}
