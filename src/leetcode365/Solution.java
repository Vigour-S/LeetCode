package leetcode365;

/**
 * Created by xiezhuohan on 2/26/17.
 */

/*
    Math problem. To compute the GCD
 */
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x + y == z || z == 0) {
            return true;
        }
        int gcd = gcd(x, y);
        if (z % gcd == 0) {
            return true;
        } else {
            return false;
        }

    }

    public int gcd(int x, int y) {
        while(y != 0) {
            int r = x % y;
            if (r == 0) {
                return y;
            }
            x = y;
            y = r;
        }
        return y;
    }
}
