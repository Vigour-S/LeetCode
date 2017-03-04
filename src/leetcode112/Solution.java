package leetcode112;

/**
 * Created by xiezhuohan on 3/2/17.
 */

import datastructures.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 *     Note that when one node has only one child.
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return helper(root, 0, sum);
    }

    public boolean helper(TreeNode node, int curSum, int sum) {
        if (node == null) {
            if (sum == curSum) {
                return true;
            } else {
                return false;
            }
        }
        if (node.left != null && node.right == null) {
            return helper(node.left, curSum + node.val, sum);
        }
        if (node.right != null && node.left == null) {
            return helper(node.right, curSum + node.val, sum);
        }
        return ((helper(node.left, curSum + node.val, sum)) | helper(node.right, curSum + node.val, sum));
    }
}
