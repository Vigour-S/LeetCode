package leetcode298;

import datastructures.TreeNode;

/**
 * Created by xiezhuohan on 2/28/17.
 */
public class Solution {
    public int longestConsecutive(TreeNode root) {
        int[]res = new int[3];
        res = helper(root);
        return Integer.max(res[1], res[2]);
    }

    public int[] helper(TreeNode node) {
        int[]res = new int[3];
        if (node == null) {
            res[0] = -999;
            res[1] = 0;
            res[2] = 0;
            return res;
        }
        // int[0]: val, int[1]: max length starts from current node, int[2]: max length doesn't start from current node
        int[] resLeft;
        int[] resRight;
        int maxCur = 0, maxNotCur = 0;
        resLeft = helper(node.left);
        resRight = helper(node.right);
        if (node.val == resLeft[0] - 1) {
            maxCur = resLeft[1] + 1;
            if (resLeft[1] + 1 > resLeft[2]) {
                maxNotCur = maxCur;
            } else {
                maxNotCur = resLeft[2];
            }
        } else {
            maxCur = 1;
            maxNotCur = resLeft[2];
        }
        if (node.val == resRight[0] - 1) {
            maxCur = Integer.max(maxCur, resRight[1] + 1);
            if (resRight[1] + 1 > resRight[2]) {
                maxNotCur = Integer.max(maxNotCur, maxCur);
            } else {
                maxNotCur = Integer.max(maxNotCur, resRight[2]);
            }
        } else {
            maxCur = Integer.max(maxCur, 1);
            maxNotCur = Integer.max(maxNotCur, resRight[2]);
        }

        res[0] = node.val;
        res[1] = maxCur;
        res[2] = maxNotCur;
        return res;
    }
}
