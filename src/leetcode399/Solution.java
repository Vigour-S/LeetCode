package leetcode399;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiezhuohan on 2/27/17.
 */

/**
 * god damn hard T T
 */

public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] res = new double[queries.length];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < equations.length; i++) {
            set.add(equations[i][0]);
            set.add(equations[i][1]);
        }
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0].equals(queries[i][1]) && set.contains(queries[i][0])) {
                res[i] = 1.0;
            } else {
                res[i] = helper(equations, values, queries[i][0], queries[i][1], 1, -1);
            }
        }
        return res;
    }

    public double helper(String[][] equations, double[] values, String a, String b, double num, int pass) {
        double res;
        for (int i = 0; i < equations.length; i++) {
            if (i == pass) {
                continue;
            }
            if (equations[i][0].equals(a)) {
                if (equations[i][1].equals(b)) {
                    return values[i] * num;
                } else {
                    res = helper(equations, values, equations[i][1], b, values[i] * num, i);
                    if (res!= -1) {
                        return res;
                    }
                }
            } else {
                if (equations[i][1].equals(a)) {
                    if (equations[i][0].equals(b)) {
                        return 1 / values[i] * num;
                    } else {
                        res = helper(equations, values, equations[i][0], b, 1 / values[i] * num, i);
                        if (res != -1) {
                            return res;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
