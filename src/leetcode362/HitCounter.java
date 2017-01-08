package leetcode362;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xiezhuohan on 1/4/17.
 */
public class HitCounter {

    Queue<Integer> queue;
    int numberOfHits;
    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new LinkedList<>();
        numberOfHits = 0;
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.add(timestamp);
        numberOfHits++;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - 300 >= queue.peek()) {
            queue.poll();
            numberOfHits--;
        }
        return numberOfHits;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
