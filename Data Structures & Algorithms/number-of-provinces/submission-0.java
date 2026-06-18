class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int len = isConnected.length;
        int[] visited = new int[len];

        for(int i = 0; i<len; i++){
            visited[i] = -1;
        }

        for(int i = 0; i<len; i++){
            if(visited[i] == -1){
                provinces += 1;
                dfs(isConnected, i, len, visited);
            }
        }

        return provinces;
    }

    public void dfs(int[][] isConnected, int city, int len, int[] visited){
        if(visited[city] == 1){
            return;
        }

        visited[city] = 1;

        for(int j = 0; j < len; j++){
            if(isConnected[city][j] == 1 && city != j){
                dfs(isConnected, j, len, visited);
            }
        }
    }
}