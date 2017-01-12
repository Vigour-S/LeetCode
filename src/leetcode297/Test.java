package leetcode297;

import datastructures.TreeNode;

/**
 * Created by xiezhuohan on 1/11/17.
 */
public class Test {
    @org.junit.Test
    public void test() {
        TreeNode node1 = new TreeNode(-1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        Codec codec = new Codec();
        codec.decode(codec.serialize(node1));
    }
}
