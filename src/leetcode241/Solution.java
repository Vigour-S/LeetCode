package leetcode241;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiezhuohan on 12/30/16.
 */

/*
    This problem can be solved using D&C
    The most difficult part of this approach is how to divide
    The basic idea is to divide the input into two parts and solve them recursively
    We will try out each of the possible divide point
    calculate left and right part of the divide point and return the result according to the operator
 */
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '-' || ch== '*' || ch == '+' ) {
                String left = input.substring(0, i);
                String right = input.substring(i+1);
                List<Integer> leftList = diffWaysToCompute(left);
                List<Integer> RightList = diffWaysToCompute(right);
                for (Integer leftRes :   leftList) {
                    for (Integer rightRes :   RightList) {
                        int res = 0;
                        switch (input.charAt(i)) {
                            case '+': res = leftRes+rightRes;
                                break;
                            case '-': res = leftRes-rightRes;
                                break;
                            case '*': res = leftRes*rightRes;
                                break;
                        }
                        list.add(res);
                    }
                }
            }
        }
        if (list.size() == 0) {
            list.add(Integer.valueOf(input));
        }
        return list;
    }
}