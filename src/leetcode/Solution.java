package leetcode;

/**
 * Created by xiezhuohan on 3/3/17.
 */
public class Solution {
    public int fun(int[] nums, int[] weights) {
        double num = Math.random();
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
        }
        double temp = 0;
        for (int i = 0; i < weights.length; i++) {
            temp += weights[i] / sum;
            if (num < temp && num > temp - weights[i]) {
                return nums[i];
            }
        }
        return 0;
    }
}
