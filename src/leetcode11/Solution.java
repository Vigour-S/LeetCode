package leetcode11;

/**
 * Created by xiezhuohan on 1/11/17.
 */

/*
    This problem is a little tricky.
    The key observation is: If we start from the two ends, always move the shorter line. (moves the longer line will not get any benefit).
    Thus, we can solve it in O(n).
 */
public class Solution {
    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int i = 0, j = height.length - 1;
        int max = Math.min(height[i], height[j]) * (j - i);
        while (i < j) {
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
        }
        return max;
    }
}
