package leetcode438;

import java.util.*;

/**
 * Created by xiezhuohan on 1/11/17.
 */
/*
    sliding window
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int len = p.length();
        List<Integer> res = new ArrayList<>();
        int hash[] = new int[256];

        if (len > s.length()) {
            return res;
        }
        for (int i = 0; i < len; i++) {
            hash[p.charAt(i)]++;

        }
        int count = 0;

        for (int i = 0; i < len - 1; i++) {
            if (hash[s.charAt(i)]-- > 0) {
                count++;
            }
        }

        for (int i = 0; i < s.length() - len + 1; i++) {
            if (hash[s.charAt(i + len - 1)]-- > 0) {
                count++;
            }

            if (count == p.length()) {
                res.add(i);
            }

            if (hash[s.charAt(i)]++ >= 0) {
                count--;
            }
        }

        return res;
    }
}
