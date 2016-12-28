package leetcode205;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiezhuohan on 12/27/16.
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        return helper(s, t) && helper(t, s);
    }

    private boolean helper(String s, String t) {
        Map<Character, Character> map = new HashMap();
        if (s.length() == t.length()) {
            for (int i=0; i<s.length(); i++) {
                char sc = s.charAt(i);
                char tc = t.charAt(i);
                if (!map.containsKey(sc)) {
                    map.put(sc, tc);
                } else {
                    if (map.get(sc) != tc) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
