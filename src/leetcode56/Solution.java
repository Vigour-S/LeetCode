package leetcode56;

/**
 * Created by xiezhuohan on 12/25/16.
 */

import datastructures.Interval;

import java.util.Comparator;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Comparator<Interval> intervalComparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start > o2.start) {
                    return 1;
                }
                if (o1.start < o2.start) {
                    return -1;
                }
                return 0;
            }
        };
        intervals.sort(intervalComparator);

        for (int i=0; i<intervals.size(); ) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            int j = i+1;
            int max = end;
            boolean overlap = false;
            while (j<intervals.size() && intervals.get(j).start <=  end) {
                overlap = true;
                if (max < intervals.get(j).end) {
                    max = intervals.get(j).end;
                }
                intervals.remove(j);
            }
            intervals.get(i).end = max;
            if (!overlap)    i++;
        }

        return intervals;
    }
}
