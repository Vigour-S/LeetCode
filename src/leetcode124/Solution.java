package leetcode124;

import datastructures.TreeNode;

/**
 * Created by xiezhuohan on 12/29/16.
 */

// This problem is a little hard
    // My first solution exceeded the time limit
    // My idea is 1. try each node as a root node
    // 2. go through its left and right sub trees to find a path whose sum is the most
    // do this recursively to find the result
    // However, this two steps can actually combine into one and reduce lots of recursions
    // When we go through the path of one node's left or right sub trees, we can simply count the sum of the
    // sum of left sub tree, right sub tree and root value to compare it with the result
public class Solution {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return result;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);

        int sum = Integer.max(left + right + node.val, node.val);
        sum = Integer.max(sum, node.val + left);
        sum = Integer.max(sum, node.val + right);

        if (sum > result) {
            result = sum;
        }

        return Integer.max(Integer.max(left + node.val, right + node.val), node.val);
    }

    // private int oneWay(TreeNode node) {
    //      if (node == null) {
    //          return 0;
    //      }

    //      int left = oneWay(node.left) + node.val;
    //      int right = oneWay(node.right) + node.val;

    //      return Integer.max(Integer.max(left, right), node.val);
    // }

}
