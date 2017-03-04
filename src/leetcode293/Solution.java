package leetcode293;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiezhuohan on 2/28/17.
 */
public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i) == s.charAt(i + 1)) {
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i, '-');
                sb.setCharAt(i + 1, '-');
                res.add(sb.toString());
            }
        }
        return res;
    }
}
