package leetcode108;

import datastructures.TreeNode;

/**
 * Created by xiezhuohan on 12/28/16.
 */

// solve by D&C
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return helper(0, nums.length - 1, nums);
    }

    private TreeNode helper(int start, int end, int[] nums) {
        if (start >= 0 && start <= end && end < nums.length) {
            int middle = (start + end) / 2;
            TreeNode node = new TreeNode(nums[middle]);
            node.left = helper(start, middle - 1, nums);    //this line I wrote it wrong first: helper(0, middle - 1, nums)
            node.right = helper(middle + 1, end, nums);
            return node;
        } else {
            return null;
        }
    }
}
