package leetcode412;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiezhuohan on 1/4/17.
 */
public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    list.add("FizzBuzz");
                } else {
                    list.add("Fizz");
                }
            } else {
                if (i % 5 == 0) {
                    list.add("Buzz");
                } else {
                    list.add(String.valueOf(i));
                }
            }
        }
        return list;
    }
}
