package leetcode317;

import java.util.*;

/**
 * Created by xiezhuohan on 2/27/17.
 */

/**
 * It's better to search from buildings.
 */
public class Solution {

    class Enum {
        int x;
        int y;
        int distance;
        public Enum(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    Queue<Enum> queue;
    Set<Integer> visited;


    public int shortestDistance(int[][] grid) {
        int res = Integer.MAX_VALUE;
        int numOfBuildings = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    numOfBuildings++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int distance = search(i, j, grid, numOfBuildings);
                    if (distance == 0) {
                        continue;
                    }
                    res = Integer.min(res, distance);
                }
            }
        }
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    public int search(int x, int y, int[][] grid, int numOfBuildings) {
        queue = new LinkedList<>();
        visited = new HashSet<>();
        int distance = 0, nums = 0;
        visited.add(x*10 + y);
        put(x + 1, y, grid, 1);
        put(x, y + 1, grid, 1);
        put(x - 1, y, grid, 1);
        put(x, y - 1, grid, 1);

        while (!queue.isEmpty()) {
            Enum pos = queue.remove();
            if (grid[pos.x][pos.y] == 1) {
                distance += pos.distance;
                nums++;
            } else {
                put(pos.x + 1, pos.y, grid, pos.distance + 1);
                put(pos.x, pos.y + 1, grid, pos.distance + 1);
                put(pos.x - 1, pos.y, grid, pos.distance + 1);
                put(pos.x, pos.y - 1, grid, pos.distance + 1);
            }
        }
        if (nums == numOfBuildings) {
            return distance;
        } else {
            return 0;
        }
    }

    public void put(int x, int y, int[][] grid, int distance) {
        if (x >=0 && y >=0 && x < grid.length && y < grid[0].length && grid[x][y] != 2 && !visited.contains(x * 10 + y)) {
            queue.add(new Enum(x, y, distance));
            visited.add(x * 10 + y);
        }
    }
}