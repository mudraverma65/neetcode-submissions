class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ogColor = image[sr][sc];

        int totalRows = image.length;
        int totalCols = image[0].length;

        if(image[sr][sc] == color){
            return image;
        }

        dfs(image, sr, sc, color, totalRows, totalCols, ogColor);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int color, int totalRows, int totalCols, int ogColor){
        int[][] directions = {{0,1}, {-1,0}, {1,0}, {0,-1}};

        image[r][c] = color;

        for(int[] direction: directions){
            int newRow = r + direction[0];
            int newCol = c + direction[1];

            if ( newRow >=0 && newRow < totalRows 
            && newCol >=0 && newCol < totalCols
            && image[newRow][newCol] == ogColor
            ){
                dfs(image, newRow, newCol, color, totalRows, totalCols, ogColor);
            }
        }
    }
}