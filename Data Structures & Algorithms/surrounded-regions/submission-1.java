class Solution {
    public void solve(char[][] board) {
        int tR = board.length;
        int tC = board[0].length;

        for (int i = 0; i < tR; i++) {
            for (int j = 0; j < tC; j++) {

                if (i == 0 || i == tR - 1 || j == 0 || j == tC - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j, tR, tC);
                    }
                }

            }
        }

        for (int i = 0; i < tR; i++){
            for (int j = 0; j < tC; j++) {

                if(board[i][j] == 'F'){
                    board[i][j] = 'O';
                } else{
                    board[i][j] = 'X';
                }

            }
        }
    }

    public void dfs(char[][] board, int r, int c, int tR, int tC) {
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        board[r][c] = 'F';

        for (int dir[] : directions) {
            int nR = r + dir[0];
            int nC = c + dir[1];

            if (nR < tR -1 && nR >= 0 && nC < tC -1 && nC >= 0 && board[nR][nC] == 'O') {
                dfs(board, nR, nC, tR, tC);
            }
        }
    }
}
