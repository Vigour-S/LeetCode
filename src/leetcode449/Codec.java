package leetcode449;

import datastructures.TreeNode;

/**
 * Created by xiezhuohan on 1/11/17.
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
        if (data.charAt(start) == '#') {   // if the element is null
            start++;    // jump over the '|' character
            return null;
        }
        int end = start;
        while (end == data.length() || data.charAt(end) != '|') {
            end++;
        }
        String num = data.substring(start, end);   //grab a single number
        TreeNode node = new TreeNode(Integer.valueOf(num));
        start = end;
        start++; node.left = deserialize(data);
        start++; node.right = deserialize(data);
        return node;
    }
}