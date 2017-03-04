package leetcode437;

import datastructures.TreeNode;

/**
 * Created by xiezhuohan on 3/2/17.
 */
public class Test {
    @org.junit.Test
    public void test() {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(-3);
        root.left = node1; root.right = node2;
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        node1.left = node3; node1.right = node4;
        node2.right = new TreeNode(11);
        node3.left = new TreeNode(3);
        node3.right = new TreeNode(-2);
        node4.right = new TreeNode(1);

        Solution solution = new Solution();
        solution.pathSum(root, 8);
    }
}
