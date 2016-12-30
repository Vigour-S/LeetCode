package leetcode89;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiezhuohan on 12/29/16.
 */

/*
    This solution was found on leetcode discussion
    Very elegant solution!
    i << n equals to pow(2, n)
    G(i) = i ^ (i/2)
    Why this solution works?
    Proof:
    Adding one to a number results in flipping all the bits behind the rightmost zero and itself
    In general, if i = XXX...XXX?01...1
                  then i+1 = XXX...XXX?10...0  (? represents the left bit of the rightmost zero)
                the bits before the rightmost zero are all the same
    Then i ^ (i >> 1) = yyy...yyy(0 ^ ?)10....0
         i ^ ((i + 1) >> 1) = yyy...yyy(1 ^ ?)10...0
    So there is only one bit different in the two results
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }
}
