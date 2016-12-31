package leetcode140;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiezhuohan on 12/30/16.
 */
public class Test {
    @org.junit.Test
    public void test() {
        Solution solution = new Solution();
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("aa");
        set.add("aaa");
        set.add("aaaa");
        set.add("aaaaa");
        set.add("aaaaaa");
        set.add("aaaaaaa");
        set.add("aaaaaaaa");
        set.add("aaaaaaaaa");
        set.add("aaaaaaaaaa");
        long start_time = System.nanoTime();
        solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", set);
        long end_time = System.nanoTime();
        double difference = (end_time - start_time)/1e6;
        System.out.println(difference);
    }
}
