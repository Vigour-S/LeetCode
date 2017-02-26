package contest20.contest520.contest526;

/**
 * Created by xiezhuohan on 2/18/17.
 */
public class Solution {

    int count = 0;

    public int countArrangement(int N) {
        int num[] = new int[16];
        helper(1, num, N);
        return count;
    }

    public boolean helper(int pos, int[] num, int N) {
        if (pos == N + 1) {
            count++;
            return true;
        }
        for (int i = 1; i <= N; i++) {
            if (num[i] != 1) {
                if (i % pos == 0 || pos % i == 0) {
                    num[i] = 1;
                    helper(pos + 1, num, N);
                    num[i] = 0;
                }
            }
        }
        return false;
    }
}
