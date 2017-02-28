package contest20.contest520.contest525;

/**
 * Created by xiezhuohan on 2/18/17.
 */

import java.util.HashMap;
import java.util.Map;

/*
    This problem is very tricky!
    First, we should replace all 0 to -1
    So we reduce this problem to solve this longest contiguous array with sum equal to 0
    Then we use a hashTable to store the sum to index
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, res = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                res = Integer.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return res;
    }
}
