package leetcode76;

import java.util.*;

/**
 * Created by xiezhuohan on 2/28/17.
 */

/**
 *  This problem is pretty common and very hard.
 *  For more info about how to solve this, see https://discuss.leetcode.com/topic/3107/accepted-o-n-solution/25
 *  and https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems
 *  We can also use an array to implement the Map and cursors to implement the queue.
 *  Time complexity is O(n)
 */
public class Solution {
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        // map is used to track the demands
        // e.g. map<a, 2> means we still need two a in the window
        Map<Character, Integer> map = new HashMap<>();
        // queue is used to mark the bounder of the window
        Deque<Integer> queue = new LinkedList<>();
        // total is used for judging if it is a valid window
        int total = t.length(), start = -1, end = s.length(), windowLen = -1;

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, (map.containsKey(ch) ? map.get(ch) + 1 : 1));
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                int num = map.get(ch);
                queue.add(i);
                map.put(ch, num - 1);
                // only when demand > 0, then total--
                if (num > 0) {
                    total--;
                }

                while (total == 0) {   //valid window is found
                    windowLen = queue.getLast() - queue.getFirst() + 1;
                    if (windowLen < end - start + 1) { // new window's length is smaller
                        start = queue.getFirst();
                        end = queue.getLast();
                    }
                    // we will look for this ch next, so demand + 1, remove it from queue.
                    char first = s.charAt(queue.getFirst());
                    queue.removeFirst();
                    map.put(first, map.get(first) + 1);
                    // only when the demand > 0, it means current window is invalid, we need to find the next ch
                    if (map.get(first) > 0) {
                        total++;
                    }
                }
            }
        }
        return (windowLen == -1) ? "" : s.substring(start, end + 1);
    }
}
