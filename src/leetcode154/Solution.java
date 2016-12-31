package leetcode154;

/**
 * Created by xiezhuohan on 12/31/16.
 */
public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        return recurrence(left, right, nums);
    }

    public int recurrence(int left, int right, int[] nums) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                return recurrence(left, mid, nums);
            }
            if (nums[mid] > nums[right]) {
                return recurrence(mid + 1, right, nums);
            }

            return recurrence(left, right - 1, nums);
        }
        return nums[left];
    }
}
