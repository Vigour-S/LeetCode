package leetcode246;

/**
 * Created by xiezhuohan on 2/27/17.
 */
public class Solution {
    public boolean isStrobogrammatic(String num) {
        int i, j;
        for (i = 0, j = num.length() - 1; i < j; i++, j--) {
            char ch1 = num.charAt(i), ch2 = num.charAt(j);
            if (ch1 == '0' || ch1 == '8' || ch1 == '1') {
                if (ch1 != ch2) {
                    return false;
                }
            } else if (ch1 == '6') {
                if (ch2 != '9') {
                    return false;
                }
            } else if (ch1 == '9') {
                if (ch2 != '6') {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (num.length() % 2 == 1) {
            if (num.charAt(i) == '0' || num.charAt(i) == '1' || num.charAt(i) == '8') {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}