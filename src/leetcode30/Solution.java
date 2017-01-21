package leetcode30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiezhuohan on 1/21/17.
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String ss : words) {
            if (map.containsKey(ss)) {
                map.put(ss, map.get(ss) + 1);
            } else {
                map.put(ss, 1);
            }
        }

        int len = words[0].length();

        for (int i = 0; i <= s.length() - len * words.length; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            for (int j = 0; i + j <= s.length() - len; j = j + len) {
                String word = s.substring(i + j, i + j + len);
                if (copy.containsKey(word)) {
                    if (copy.get(word) == 1) {
                        copy.remove(word);
                    } else {
                        copy.put(word, copy.get(word) - 1);
                    }
                } else {
                    break;
                }
            }
            if (copy.isEmpty()) {
                res.add(i);
            }
        }
        return res;
    }
}