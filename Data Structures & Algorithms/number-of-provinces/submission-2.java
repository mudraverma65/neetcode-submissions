class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int len = isConnected.length;
        int[] visited = new int[len];

        Queue<Integer> line = new LinkedList<>();

        for(int i = 0; i<len; i++){
            visited[i] = -1;
        }

        for(int i = 0; i<len; i++){
            if(visited[i] != -1){
                continue;
            }
            provinces ++;
            visited[i] = 1;
            line.offer(i);
            while(!line.isEmpty()){
                int curr = line.poll();
                for(int j=0; j<len; j++){
                    if(visited[j] == -1 && j != curr && isConnected[curr][j] == 1){
                        visited[j] = 1;
                        line.offer(j);
                    }
                }
            }
        }

        return provinces;
    }

}