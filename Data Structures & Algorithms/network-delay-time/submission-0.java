class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> graph = new HashMap<Integer, List<int[]>>();
        for(int[] time: times){
            graph.computeIfAbsent(time[0], x-> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        HashMap<Integer, Integer> maxDistance = new HashMap<>();
        for(int i =1; i<=n; i++) {
            maxDistance.put(i, Integer.MAX_VALUE);
        }

        dfs(graph, maxDistance, k, 0);

        int res = Collections.max(maxDistance.values());
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public void dfs( HashMap<Integer, List<int[]>> graph, HashMap<Integer, Integer> maxDistance, int k, int time){
        if(time >= maxDistance.get(k)){
            return;
        }
        maxDistance.put(k, time);
        
        if(!graph.containsKey(k)){
            return;
        }

        for(int[] path: graph.get(k)){
            dfs(graph, maxDistance, path[0], time + path[1]);
        }

    }


}
