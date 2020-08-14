/**
 * ClassName:   Solution_130
 * Data:        2020/8/13
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
130. 被围绕的区域
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
示例:
X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：
X X X X
X X X X
X X X X
X O X X
 */
public class Solution_130 {
    public void solve(char[][] board) {
        if (board.length == 0) return;
        int row_len = board.length;
        int col_len = board[0].length;
        for (int i = 0; i < row_len; i++){
            helper(board, i, 0);
            helper(board, i, col_len - 1);
        }

        for (int i = 0; i < col_len; i++) {
            helper(board, 0, i);
            helper(board, row_len - 1, i);
        }

        for (int i = 0; i < row_len; i++) {
            for (int j = 0; j < col_len; j++) {
                if (board[i][j] != 'Y')
                    board[i][j] = 'X';
                else
                    board[i][j] = 'O';
            }
        }
    }

    public void helper(char[][] board, int row, int col){
        if (board[row][col] != 'O') return;
        board[row][col] = 'Y';
        if (row - 1 >= 0 && board[row - 1][col] == 'O')
            helper(board, row - 1, col);

        if (row + 1 < board.length && board[row + 1][col] == 'O')
            helper(board, row + 1, col);

        if (col - 1 >= 0 && board[row][col - 1] == 'O')
            helper(board, row, col - 1);

        if (col + 1 < board[0].length && board[row][col + 1] == 'O')
            helper(board, row, col + 1);
    }
}
