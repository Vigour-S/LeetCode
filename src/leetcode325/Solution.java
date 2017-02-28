package leetcode325;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiezhuohan on 2/26/17.
 */

/*
    tricky problem.
 */
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            if (map.containsKey(sum - k)) {
                res = Integer.max(res, i - map.get(sum - k));
            }
        }

        return res;
    }
}
