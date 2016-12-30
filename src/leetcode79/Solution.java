package leetcode79;


/**
 * Created by xiezhuohan on 12/29/16.
 */

/*
    The difficult part of this problem is how to track the cell we already visited and how to un-mark it when we backtrack
    First, I use Hashset to record the visited cells, I save String.valueOf(i) + String.valueOf(j) in a set to record the visited cells
    But it turns out it exceeds the time limit
    Then I record the visited cells in place of the array and change it back when I backtrack. This is much more time and space efficient.
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return false;

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(i, j, word, board, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean helper(int i, int j, String word, char[][] board, int pos) {
        if (i >=0 && j>= 0 && i < board.length && j < board[0].length) {

            if (board[i][j] == word.charAt(pos++)) {
                char temp = board[i][j];
                board[i][j] = '#';
                if (pos == word.length()) {
                    return true;
                } else {
                    boolean res =  (helper(i + 1, j, word, board, pos)
                            || helper(i - 1, j, word, board, pos)
                            || helper(i, j + 1, word, board, pos)
                            || helper(i, j - 1, word, board, pos));
                   board[i][j] = temp;  // This line is important!
                    return res;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
