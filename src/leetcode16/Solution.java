package leetcode16;

import java.util.Arrays;

/**
 * Created by xiezhuohan on 12/28/16.
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {

        if (nums.length <= 3) {
            int sum = 0;
            for (int num: nums) {
                sum += num;
            }
            return sum;
        }

        Arrays.sort(nums);
        int res = 0, closest = Integer.MAX_VALUE;
        for (int i=0; i<nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < closest) {
                    closest = Math.abs(sum - target);
                    res = sum;
                }
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
