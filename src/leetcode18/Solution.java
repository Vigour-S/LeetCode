package leetcode18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiezhuohan on 1/21/17.
 */
/*
    using 3sum to solve 4sum
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            threeSum(i + 1, nums.length - 1, target - nums[i], nums[i], nums, res);
        }
        return res;
    }

    public void threeSum(int left, int right, int target, int start, int[] nums, List<List<Integer>> res) {

        for (int i = left; i < right - 1; i++) {
            if (i - 1 >= left && nums[i - 1] == nums[i]) {
                continue;
            }
            int l = i + 1, r = right;
            while (l != r) {
                if ( (l - 1 > i && nums[l] == nums[l - 1]) || nums[i] + nums[l] + nums[r] < target) {
                    l++;
                } else if ( (r + 1 <= right && nums[r] == nums[r + 1]) || nums[i] + nums[l] + nums[r] > target) {
                    r--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);list.add(nums[i]);list.add(nums[l]);list.add(nums[r]);
                    res.add(list);
                    l++;
                }
            }
        }
    }
}
