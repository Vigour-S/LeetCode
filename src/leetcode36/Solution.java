package leetcode36;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiezhuohan on 1/20/17.
 */

/*
    The difficult part is how to compute each sub-square
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();
            Set<Character> square = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && rows.contains(board[i][j])) {
                    return false;
                } else {
                    rows.add(board[i][j]);
                }

                if (board[j][i] != '.' && cols.contains(board[j][i])) {
                    return false;
                } else {
                    cols.add(board[j][i]);
                }

                int k = (i / 3) * 3 + j / 3, m = (i * 3) % 9 + j % 3;   // this is the difficult part
                if (board[k][m] != '.' && square.contains(board[k][m])) {
                    return false;
                } else {
                    square.add(board[k][m]);
                }
            }
        }
        return true;

    }
}
