package leetcode445;

import datastructures.ListNode;

import java.util.Stack;

/**
 * Created by xiezhuohan on 1/3/17.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = new ListNode(0), node = head;
        while (!stack1.empty() || !stack2.empty() || carry != 0) {  // carry != 0 should not be forgotten
            int i1 = stack1.empty() ? 0 : stack1.pop();
            int i2 = stack2.empty() ? 0 : stack2.pop();
            int num = i1 + i2 + carry;
            if (num >= 10) {
                carry = 1;
                num = num % 10;
            } else {
                carry = 0;
            }
            stack3.push(num);
        }

        while (!stack3.empty()) {
            node.next = new ListNode(stack3.pop());
            node = node.next;
        }

        return head.next;
    }
}