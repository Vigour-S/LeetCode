package leetcode402;

import java.util.*;

/**
 * Created by xiezhuohan on 12/15/16.
 */

//this solution is not optimal

public class Solution {
    public String removeKdigits(String num, int k) {
        Map<Character, PriorityQueue> map = new HashMap<>();

        for (int i=0; i<num.length(); i++) {
            map.putIfAbsent(num.charAt(i), new PriorityQueue<Integer>());
            map.get(num.charAt(i)).add(i);
        }

        SortedSet<Character> keys = new TreeSet<Character>(map.keySet());
        int len = num.length() - k;
        if (len == 0) return "0";
        String result = "";
        int start = -1;
        Iterator<Character> iterator;
        iterator = keys.iterator();
            while (iterator.hasNext()) {
                char digit = iterator.next();
                PriorityQueue<Integer> pq = map.get(digit);
                while (!pq.isEmpty()) {
                    int index = pq.peek();
                    if (num.length() - index >= len && index > start) {
                        result += digit;
                        len--;
                        if (len == 0) break;
                        start = index;
                        pq.poll();
                        iterator = keys.iterator();
                        break;
                    } else {
                        if (index <= start)
                            pq.poll();
                        else break;
                    }
                }
                if (len == 0) break;
            }

        if (result == "") {
            return "0";
        }

        //remove all the 0 at the head
        int sub = 0;
        while (sub<result.length()) {
            if (result.charAt(sub) != '0') {
                break;
            }
            sub++;
        }

        if (sub == result.length()) {
            return "0";
        }

        return result.substring(sub);
    }
}
