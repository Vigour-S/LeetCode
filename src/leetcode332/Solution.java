package leetcode332;

import java.util.*;

/**
 * Created by xiezhuohan on 12/15/16.
 */
public class Solution {
    LinkedList<String> result = new LinkedList<>();
    private Map<String, PriorityQueue> hashTable = new HashMap<>();

    public List<String> findItinerary(String[][] tickets) {

        for (String[] s : tickets) {
            hashTable.putIfAbsent(s[0],new PriorityQueue<>());
            hashTable.get(s[0]).add(s[1]);
        }
        dfs("JFK");
        return result;
    }

    public void dfs(String departure) {
        PriorityQueue<String> pq = hashTable.get(departure);
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }
        result.addFirst(departure);
    }
}
