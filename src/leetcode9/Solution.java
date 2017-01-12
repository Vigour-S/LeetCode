package leetcode9;

/**
 * Created by xiezhuohan on 1/11/17.
 */
/*
    easy problem, but some conner cases to be considered.
    negative. double to int.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = x, digits = 0;
        while (num > 0) {
            num /= 10;
            digits++;
        }

        int i = digits, j = 1;
        while (i > j) {
            if ((x / (int) Math.pow(10, i - 1)) % 10 != (int) (x % Math.pow(10, j)) / ( (int) Math.pow(10, j - 1))) {
                return false;
            }
            i--; j++;
        }
        return true;
    }
}
