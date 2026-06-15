class Solution {
    int perimeter = 0;
    public int islandPerimeter(int[][] grid) {
        int tR = grid.length;
        int tC = grid[0].length;

        for(int i=0; i<tR; i++){
            for (int j=0; j<tC; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j, tR, tC);
                }
            }
        }
        return perimeter;
    }

    public void dfs(int[][] grid, int row, int col, int tR, int tC){
        int[][] directions = {{0,1}, {0,-1},{1,0}, {-1,0}};
        grid[row][col] = -1;
        for(int[] dir: directions){
            int nR = row + dir[0];
            int nC = col + dir[1];

            if(nR < 0 || nR >= tR || nC < 0 || nC >= tC){
                perimeter+=1;
            } else if (grid[nR][nC] == 0){
                perimeter += 1;
            } else if (grid[nR][nC] == 1){
                dfs(grid, nR, nC, tR, tC );
            }
        }
    }
}