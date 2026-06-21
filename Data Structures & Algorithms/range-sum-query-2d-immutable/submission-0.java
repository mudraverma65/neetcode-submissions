class NumMatrix {
    int[][] data;
    int rows;
    int cols;

    public NumMatrix(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        data = new int[rows][cols];

        for(int i=0; i< rows; i++){
            for(int j =0; j<cols; j++){
                data[i][j] = matrix[i][j];
                if(i > 0){
                    data[i][j] += data[i-1][j];
                }
                if(j>0){
                    data[i][j] += data[i][j-1];
                }

                if (i > 0 && j > 0) {
                    data[i][j] -= data[i - 1][j - 1];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = data[row2][col2];
        if(row1 > 0){
            total -= data[row1-1][col2];
        }

        if(col1>0){
            total -= data[row2][col1-1];
        }

        if(row1 >0 && col1 > 0){
            total+= data[row1-1][col1-1];
        }

        return total;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */