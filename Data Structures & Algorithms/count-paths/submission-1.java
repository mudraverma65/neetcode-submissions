class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for(int[] it: memo){
            Arrays.fill(it,-1);
        }
        return dfs(0,0,m-1,n-1);
    }

    public int dfs(int i, int j, int m, int n){
        if(i == m && j == n){
            return 1;
        } 
        
        if(i>m || j>n){
            return 0;
        } 

        if(memo[i][j] == -1){
            memo[i][j] = dfs(i+1, j, m, n) + dfs(i, j+1, m, n);
        }

        return memo[i][j];
    }
}
