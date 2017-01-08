package leetcode457;

/**
 * Created by xiezhuohan on 1/5/17.
 */
public class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int j, count;
        boolean forward, cycle;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            j = i;
            forward = nums[j] > 0;
            cycle = false;
            count = 0;
            while (nums[j] != 0) {
                if ((forward && nums[j] < 0) || (!forward && nums[j] > 0)) {
                    break;
                }
                if (j + nums[j] >= nums.length || j + nums[j] < 0) {
                    cycle = true;
                }
                int temp = j;
                if (forward) {
                    j = (j + nums[j]) % nums.length;
                } else {
                    j = (nums.length + j - (-nums[j] % nums.length)) % nums.length;
                }
                nums[temp] = 0;
                count++;
            }
            if (i == j && cycle && count > 1) {
                return true;
            }
        }
        return false;
    }
}
