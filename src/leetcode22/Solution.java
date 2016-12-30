package leetcode22;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xiezhuohan on 12/29/16.
 */

/*
Basic idea:
Try out every possible answer
We add one Parenthesis each time and each time we have two choice:
    1. add a left Parenthesis
    2. add a right Parenthesis if possible
    Do this recursively to solve the problem.
    How to determine when can I add a right Parenthesis?
    Use a variable to track this.
 */
public class Solution {

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        String s = "";
        helper(n, s, 0);

        Set<String> set = new HashSet<>();


        return result;
    }

    public void helper(int len, String s, int rightParen) {
        if (len == 0) {
            while (rightParen > 0) {
                s += ')';
                rightParen--;
            }
            result.add(s);
            return;
        } else {
            if (rightParen > 0) {
                helper(len, s+')', rightParen - 1);
            }
            helper(len-1, s+'(', rightParen + 1);
        }
    }
}
