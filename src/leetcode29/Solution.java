package leetcode29;

/**
 * Created by xiezhuohan on 3/1/17.
 */
/*
    be careful of overflow!
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        int flag = 1;
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            flag = -1;
        }
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        if (dividend == 0 || ldividend < ldivisor) {
            return 0;
        }
        long res = helper(ldividend, ldivisor, 1, ldivisor);
        // handle overflow
        if (res > Integer.MAX_VALUE) {
            if (flag == 1) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        if (flag == -1) {
            return (int)(0 - res);
        } else {
            return (int)res;
        }
    }

    public long helper(long dividend, long divisor, int times, long temp) {
        if (dividend < divisor) {
            return 0;
        }

        long sum1 = temp, sum2 = times;
        while (dividend >= sum1 + temp + temp) {
            temp += temp;
            sum1 += temp;
            times += times;
            sum2 += times;
        }

        return sum2 + helper(dividend - sum1, divisor, 1, divisor);
    }
}
