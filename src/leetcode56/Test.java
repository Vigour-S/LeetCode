package leetcode56;

import datastructures.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiezhuohan on 12/25/16.
 */

public class Test {
    @org.junit.Test
    public void test() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(7, 10));
        intervals.add(new Interval(8, 12));
        intervals.add(new Interval(11, 13));
        intervals.add(new Interval(0, 5));
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 4));
        intervals.add(new Interval(6, 9));

        Solution solution = new Solution();
        solution.merge(intervals);
    }
}
