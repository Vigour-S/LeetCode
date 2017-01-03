package leetcode138;

import datastructures.RandomListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiezhuohan on 1/2/17.
 */

/*
    This problem actually can be done in O(1) space
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode node = head;
        HashMap<RandomListNode, Set<RandomListNode>> map = new HashMap<>();
        if (head == null) {
            return null;
        }
        RandomListNode newHead = new RandomListNode(node.label);
        RandomListNode newNode = newHead;
        if (node.random != null) {
            Set<RandomListNode> set = new HashSet<>();
            set.add(newHead);
            map.put(node.random, set);
        }
        node = node.next;
        while (node != null) {
            RandomListNode temp = new RandomListNode(node.label);
            if (node.random != null) {
                if (map.containsKey(node.random)) {
                    map.get(node.random).add(temp);
                } else {
                    Set<RandomListNode> set = new HashSet<>();
                    set.add(temp);
                    map.put(node.random, set);
                }

            }
            newNode.next = temp;
            newNode = temp;
            node = node.next;
        }
        newNode.next = null;

        newNode = newHead; node = head;
        while (newNode != null) {
            if (map.containsKey(node)) {
                for (RandomListNode each : map.get(node)) {
                    each.random = newNode;
                }
            }
            newNode = newNode.next;
            node = node.next;
        }

        return newHead;
    }
}
