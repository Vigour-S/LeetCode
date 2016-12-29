package leetcode17;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiezhuohan on 12/28/16.
 */
public class Solution {
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return result;
        String[] numbers = new String[10];
        numbers['2' - '0'] = "abc";
        numbers['3' - '0'] = "def";
        numbers['4' - '0'] = "ghi";
        numbers['5' - '0'] = "jkl";
        numbers['6' - '0'] = "mno";
        numbers['7' - '0'] = "pqrs";
        numbers['8' - '0'] = "tuv";
        numbers['9' - '0'] = "wxyz";
        String res = "";
        helper(res, digits, numbers, 0);
        return result;
    }

    private void helper(String res, String digits, String[] numbers, int i) {
        if (i < digits.length()) {
            char ch = digits.charAt(i);
            for (int j=0; j<numbers[ch - '0'].length(); j++) {
                helper(res + numbers[ch - '0'].charAt(j), digits, numbers, i+1);    //first wrote it wrong in "++i"
            }
        } else{
            result.add(res);
        }
    }
}