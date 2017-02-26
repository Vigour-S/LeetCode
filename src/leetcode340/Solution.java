package leetcode340;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiezhuohan on 2/25/17.
 */
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int res;
        Map<Character, Integer> map = new HashMap<>();

        int j;
        for (j = 0; j < s.length(); j++) {
            if (!map.containsKey(s.charAt(j))) {
                if (map.size() == k) {
                    break;
                }
                map.put(s.charAt(j), 1);
            } else {
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
            }
        }

        res = j;
        if (res == 0) {
            return res;
        }

        for (int i = 1; i < s.length() && j < s.length(); i++) {
            char ch  = s.charAt(i - 1);
            int num = map.get(ch);
            if (num == 1) {
                map.remove(ch);
            } else {
                map.put(ch, num - 1);
            }

            for (; j < s.length(); j++) {
                if (!map.containsKey(s.charAt(j))) {
                    if (map.size() == k) {
                        break;
                    }
                    map.put(s.charAt(j), 1);
                } else {
                    map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                }
            }
            res = Integer.max(res, j - i);
        }
        return res;
    }
}

