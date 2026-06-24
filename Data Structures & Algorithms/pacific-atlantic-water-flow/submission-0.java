class Solution {
    int rows;
    int cols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;

        boolean[][] memoP = new boolean[rows][cols];
        boolean[][] memoA = new boolean[rows][cols];

        for(int i=0; i<rows; i++){
            dfs(heights, memoP, i, 0); //left - Pacific
            dfs(heights, memoA, i, cols-1); //right - Atlantic
        }

        for(int j=0; j<cols; j++){
            dfs(heights, memoP, 0, j); // top - pacific
            dfs(heights, memoA, rows-1, j); // bottom - Ata
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if(memoP[i][j] && memoA[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    public void dfs(int[][] heights, boolean[][] vis, int row, int col){
        vis[row][col] = true;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        for(int[] dir: dirs){
            int nR = dir[0] + row;
            int nC = dir[1] + col;

            if(nR < 0 || nR >= rows || nC <0 || nC >= cols){
                continue;
            }

            if(vis[nR][nC]){
                continue;
            }

            if(heights[nR][nC] < heights[row][col]){
                continue;
            }
            dfs(heights, vis, nR, nC);
        }
    }
}
