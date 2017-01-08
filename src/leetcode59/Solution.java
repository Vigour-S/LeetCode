package leetcode59;

/**
 * Created by xiezhuohan on 1/7/17.
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        helper(res, 0, 0, 1, 0);
        return res;
    }

    private void helper(int[][] res, int i, int j, int val, int direction) {

        if (i >= 0 && j >= 0 && i < res.length && j < res.length) {
            if (res[i][j] != 0) {
                return;
            } else {
                res[i][j] = val;
            }
            if (direction == 0 || i - 1 < 0 || (direction == 3 && res[i - 1][j] != 0))
                helper(res, i, j + 1, val + 1, 0);
            if (direction == 1 || j + 1 >= res.length || (direction == 0 && res[i][j + 1] != 0))
                helper(res, i + 1, j, val + 1, 1);
            if (direction == 2 || i + 1 >= res.length || (direction == 1 && res[i + 1][j] != 0))
                helper(res, i, j - 1, val + 1, 2);
            if (direction == 3 || j - 1 < 0 || (direction == 2 && res[i][j - 1] != 0))
                helper(res, i - 1, j, val + 1, 3);
        }
    }
}
