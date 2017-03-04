package leetcode418;

/**
 * Created by xiezhuohan on 2/28/17.
 */

/**
 * god damn hard!
 */
public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String ss = String.join(" ", sentence) + " ";
        int start = 0;
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (ss.charAt(start % ss.length()) == ' ') {
                start++;
            } else {
                while (start > 0 && ss.charAt((start - 1) % ss.length()) != ' ') {
                    start--;
                }
            }
        }
        return start / ss.length();
    }
}
