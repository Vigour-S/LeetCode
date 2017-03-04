package leetcode113;

/**
 * Created by xiezhuohan on 3/2/17.
 */

import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return list;
        }
        helper(root, 0, sum, new ArrayList<>());
        return list;
    }

    public void helper(TreeNode node, int curSum, int sum, List<Integer> l) {
        if (node.left == null && node.right == null) {
            if (sum == curSum + node.val) {
                l.add(node.val);
                list.add(l);
            }
            return;
        }
        l.add(node.val);
        if (node.left != null && node.right == null) {
            helper(node.left, curSum + node.val, sum, l);
        } else if (node.right != null && node.left == null) {
            helper(node.right, curSum + node.val, sum, l);
        } else {
            List<Integer> newList = new ArrayList<>();
            for (int i : l) {
                newList.add(i);
            }
            helper(node.left, curSum + node.val, sum, l);
            helper(node.right, curSum + node.val, sum, newList);
        }
    }
}
