package leetcode297;

/**
 * Created by xiezhuohan on 1/11/17.
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
public class Codec {
    int start = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return String.valueOf(root.val) + "|" + serialize(root.left) + "|" + serialize(root.right);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        start = 0;
        return decode(data);
    }

    public TreeNode decode(String data) {
        if (data.charAt(start) == '#') {
            start++;
            return null;
        }
        int end = start;
        while (end == data.length() || data.charAt(end) != '|') {
            end++;
        }
        String num = data.substring(start, end);
        TreeNode node = new TreeNode(Integer.valueOf(num));
        start = end;
        node.left = decode(data);start++;
        node.right = decode(data);start++;
        return node;
    }
}
