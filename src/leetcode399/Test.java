package leetcode399;

/**
 * Created by xiezhuohan on 2/27/17.
 */
public class Test {
    @org.junit.Test
    public void test() {
        Solution solution = new Solution();
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        solution.calcEquation(equations, values, queries);
    }
}
