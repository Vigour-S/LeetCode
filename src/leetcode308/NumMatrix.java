package leetcode308;

/**
 * Created by xiezhuohan on 2/25/17.
 */

/*
    binary indexed tree: https://www.youtube.com/watch?v=CWDQJGaN1gY
    This problem can be solved by binary indexed tree or segment tree.
    lowerbit: the most right 1 bit
    e.g. 7 = 2^2 + 2^1 + 2^0
    the cell which index is 7 in the binary indexed tree represents sum of the original array from 6 to 6
    e.g. 8 = 0 + 2^3
    represents sum of the original array from 0 to 7
    How to calculate the sum of 0 - 5 ?
    Start from 6, add its parent, all the way down to the root.
    tree[6] + tree[4] + tree[0]
    How to get a parent?
    1. 2's complement
    2. AND it with original number
    3. subtract from original number
    How to get a next?
    1. 2's complement
    2. AND with original number
    3. Add to original number

*/
public class NumMatrix {

    int[][] num;
    int[][] bit;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        num = new int[matrix.length][matrix[0].length];
        bit = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        if (num.length == 0 || num[0].length == 0) return;
        int sub = val - num[row][col];
        num[row][col] = val;
        for (int i = row + 1; i < bit.length; i += i & (-i)) {
            for (int j = col + 1; j < bit[0].length; j += j & (-j)) {
                bit[i][j] += sub;
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row1, col1) + sum(row2 + 1, col2 + 1) - sum(row1, col2 + 1) - sum(row2 + 1, col1);
    }

    public int sum(int row, int col) {
        int res = 0;
        //i, j should not be equal to 0 to avoid infinite loop
        for (int i = row; i > 0; i -= i & (-i)) {
            for (int j = col; j > 0; j -= j & (-j)) {
                res += bit[i][j];
            }
        }
        return res;
    }
}
// update and sum time should be O(log(m) * log(n))
// create time should be mn O(log(m) * log(n))

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
