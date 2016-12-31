package leetcode140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by xiezhuohan on 12/30/16.
 */

/*
    This problem has a strict time limit
    Merely use DFS will get a TLE
    Time improvement is needed
    We use two ways to do that:
    1. if the word we scan is longer than the longest word in the dictionary, we skip it
    We implement this using a global variable -- max
    2. We use a hashMap to record the  result we have made (This will save plenty of time!)
    The next time we need to do the recursion for the remain substring, we first look up the hashMap. If it exists,
    we use it directly.
 */
public class Solution {

    int max = 0;
    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, Set<String> wordDict) {
        for (String word : wordDict) {
            max = Integer.max(word.length(), max);
        }
        return helper(s, wordDict, 0);
    }

    private List<String> helper(String s, Set<String> wordDict, int i) {
        List<String> list = new ArrayList<>();
        if (i == s.length()) {
            return null;
        }
        for (int j = i; j < s.length() && (j - i) < max; j++) {
            String word = s.substring(i, j + 1);
            if (wordDict.contains(word)) {
                List<String> res;
                if (map.containsKey(j + 1)) {
                    res = map.get(j + 1);
                } else {
                    res = helper(s, wordDict, j + 1);
                }
                if (res == null) {
                    list.add(word);
                } else {
                    for (int k = 0; k < res.size(); k++) {
                        list.add(word + " " +res.get(k));
                    }
                }
            }
        }
        // if list is empty, we still need to put it!
        map.putIfAbsent(i, new ArrayList<>(list));
        return list;
    }
}
