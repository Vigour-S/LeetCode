package leetcode217;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiezhuohan on 12/15/16.
 */

/*
    brute force: O(n2)
    optimal solution: O(n) using hashTable, O(nlogn) using sort
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}
