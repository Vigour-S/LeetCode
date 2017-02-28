package contest20.contest520.contest517;

/**
 * Created by xiezhuohan on 2/26/17.
 */

// Tricky problem. See https://discuss.leetcode.com/topic/79938/super-short-easy-java-o-n-solution/11

public class Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for (int i=0; i<machines.length; i++) {
            sum += machines[i];
        }
        int avg = sum / machines.length;
        if (sum % machines.length != 0) {
            return -1;
        }
        int max = 0;
        for (int i = 0; i < machines.length; i++) {
            machines[i] -= avg;
            max = Integer.max(max, machines[i]);
        }
        int res = max;
        for (int i = 0; i < machines.length - 1; i++) {
            res = Integer.max(Math.abs(machines[i]), res);
            machines[i + 1] += machines[i];
        }

        return res;

    }
}
