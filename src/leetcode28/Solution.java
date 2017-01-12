package leetcode28;

/**
 * Created by xiezhuohan on 1/11/17.
 */
public class Solution {
    public int strStr(String haystack, String needle) {

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = i;
            while (j - i < needle.length() && haystack.charAt(j) == needle.charAt(j - i)) {
                j++;
            }
            if (j - i == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
