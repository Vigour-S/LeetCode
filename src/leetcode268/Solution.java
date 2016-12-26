package leetcode268;

/**
 * Created by xiezhuohan on 12/25/16.
 */
public class Solution {
    public int missingNumber(int[] nums) {

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= (nums[i] ^ i);
        }
        return result ^ 0 ^ (nums.length);
    }
}