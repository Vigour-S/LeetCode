package leetcode294;

/**
 * Created by xiezhuohan on 2/28/17.
 */
public class Solution {
    StringBuilder sb;
    public boolean canWin(String s) {
        sb = new StringBuilder(s);
        return helper();
    }

    public boolean helper() {
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == '+' && sb.charAt(i + 1) == '+') {
                sb.setCharAt(i, '-');
                sb.setCharAt(i + 1, '-');
                if (!helper()) {
                    sb.setCharAt(i, '+');
                    sb.setCharAt(i + 1, '+');
                    return true;
                }
                sb.setCharAt(i, '+');
                sb.setCharAt(i + 1, '+');
            }
        }
        return false;
    }
}
