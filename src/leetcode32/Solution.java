package leetcode32;

import java.util.Stack;

/**
 * Created by xiezhuohan on 1/21/17.
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[s.length()];
        int max = 0;
        if (s.charAt(0) == '(') {
            stack.push(0);
        }

        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    if (stack.peek() - 1 >= 0) {
                        dp[i] = dp[i - 1] + 1 + dp[stack.pop() - 1];
                    } else {
                        dp[i] = dp[i - 1] + 1;stack.pop();
                    }
                    max = max > dp[i] ? max : dp[i];
                } else {
                    dp[i] = 0;
                }
            } else {
                stack.push(i);
            }
        }

        return max * 2;
    }
}
