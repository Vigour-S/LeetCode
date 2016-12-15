package leetcode249;

import java.util.*;

/**
 * Created by xiezhuohan on 12/14/16.
 */
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strings) {
            String key = "";
            for (int i=1; i<s.length(); i++) {
                char a = s.charAt(i - 1);
                char b = s.charAt(i);
                if (b - a < 0) {
                    b = (char)(b + 26);
                }
                int offset = b - a;
                key = key + offset;
            }


            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<String>();
                map.put(key, list);
            }
            map.get(key).add(s);
        }

        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
}
