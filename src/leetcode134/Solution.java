package leetcode134;

/**
 * Created by xiezhuohan on 12/27/16.
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] remain = new int[gas.length];
        for (int i=0; i<gas.length; i++) {
            remain[i] = gas[i] - cost[i];
        }

        boolean[] flag = new boolean[gas.length];
        flag[0] = true;
        int nums = 0, gasRemain = 0, i = 0, start = 0;
        while (nums < gas.length) {
            gasRemain += remain[i];
            if (gasRemain < 0) {
                start = i + 1;
                if (start < flag.length) {
                    if (flag[start]) {
                        return -1;
                    } else {
                        flag[start] = true;
                    }
                }
                gasRemain = 0;
                nums = -1;
                i = start;
            } else {
                i = (i + 1) % gas.length;
            }
            nums++;
            if (start == gas.length) {
                return -1;
            }
        }

        return start;
    }
}
